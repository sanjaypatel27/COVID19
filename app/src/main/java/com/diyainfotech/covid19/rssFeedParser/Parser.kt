package com.diyainfotech.covid19.rssFeedParser

import com.diyainfotech.covid19.rssFeedParser.engine.CoroutineEngine
import com.diyainfotech.covid19.rssFeedParser.engine.XMLFetcher
import com.diyainfotech.covid19.rssFeedParser.engine.XMLParser
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class Parser(private val okHttpClient: OkHttpClient? = null)  {
    private lateinit var onComplete: OnTaskCompleted
    private lateinit var service: ExecutorService

    private val parserJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parserJob + Dispatchers.Default

    fun onFinish(onComplete: OnTaskCompleted) {
        this.onComplete = onComplete
    }

    fun execute(url: String) {
        Executors.newSingleThreadExecutor().submit {
            service = Executors.newFixedThreadPool(2)
            val f1 = service.submit<String>(XMLFetcher(url, okHttpClient))
            try {
                val rssFeed = f1.get()
                val f2 = service.submit(XMLParser(rssFeed))
                onComplete.onTaskCompleted(f2.get())
            } catch (e: Exception) {
                onComplete.onError(e)
            } finally {
                service.shutdown()
            }
        }
    }

    /**
     *  Cancel the execution of the fetching and the parsing.
     */
    fun cancel() {
        if (::service.isInitialized) {
            // The client is using Java!
            try {
                if (!service.isShutdown) {
                    service.shutdownNow()
                }
            } catch (e: Exception) {
                onComplete.onError(e)
            }
        } else {
            // The client is using Kotlin and coroutines
            if (coroutineContext.isActive) {
                coroutineContext.cancel()
            }
        }
    }

    @Throws(Exception::class)
    suspend fun getChannel(url: String) =
        withContext(coroutineContext) {
            val xml = CoroutineEngine.fetchXML(url, okHttpClient)
            return@withContext CoroutineEngine.parseXML(xml)
        }
}