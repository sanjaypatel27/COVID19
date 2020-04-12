package com.diyainfotech.covid19.rssFeedParser.core

import okhttp3.OkHttpClient
import okhttp3.Request

object CoreXMLFetcher {
    @Throws(Exception::class)
    fun fetchXML(url: String, okHttpClient: OkHttpClient? = null): String {
        var client = okHttpClient
        if (client == null) {
            client = OkHttpClient()
        }
        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        return response.body!!.string()
    }
}