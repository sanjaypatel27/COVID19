package com.diyainfotech.covid19.api

import com.diyainfotech.covid19.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitFactory {

    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(EndPoints.COVID19_INDIA_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())

    fun retrofit(httpClient: OkHttpClient.Builder): Retrofit = builder
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val httpClient: OkHttpClient.Builder = getHttpClientDefaultConfig()


    private fun getHttpClientDefaultConfig(): OkHttpClient.Builder {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)

        return httpClient
    }
}