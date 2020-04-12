package com.diyainfotech.covid19.rssFeedParser.engine

import com.diyainfotech.covid19.rssFeedParser.core.CoreXMLFetcher
import com.diyainfotech.covid19.rssFeedParser.core.CoreXMLParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient

object CoroutineEngine {

    @Throws(Exception::class)
    suspend fun fetchXML(url: String, okHttpClient: OkHttpClient?) =
        withContext(Dispatchers.IO) {
            return@withContext CoreXMLFetcher.fetchXML(url, okHttpClient)
        }

    @Throws(Exception::class)
    suspend fun parseXML(xml: String) =
        withContext(Dispatchers.IO) {
            return@withContext CoreXMLParser.parseXML(xml)
        }
}
