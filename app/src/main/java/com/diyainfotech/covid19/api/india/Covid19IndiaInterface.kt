package com.diyainfotech.covid19.api.india

import com.diyainfotech.covid19.api.EndPoints
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Covid19IndiaInterface {
    @GET(EndPoints.INDIA_ALL_DATA)
    fun getIndiaAllDataAsync(): Deferred<Response<IndiaData>>
}