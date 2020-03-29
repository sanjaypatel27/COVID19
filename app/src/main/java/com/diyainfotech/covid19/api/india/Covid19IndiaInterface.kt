package com.diyainfotech.covid19.api.india

import com.diyainfotech.covid19.api.EndPoints
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface Covid19IndiaInterface {
    @GET(EndPoints.INDIA_ALL_DATA)
    fun getIndiaAllDataAsync(): Deferred<Response<IndiaData>>

    @GET(EndPoints.INDIA_STATE_DISTRICT_WISE_DATA)
    fun getAllStateDataAsync(): Deferred<Response<StateWiseDataResponse>>
}