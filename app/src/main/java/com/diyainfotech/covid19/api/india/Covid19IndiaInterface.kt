package com.diyainfotech.covid19.api.india

import com.diyainfotech.covid19.api.EndPoints
import com.diyainfotech.covid19.api.india.notification.NotificationList
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Covid19IndiaInterface {
    @GET(EndPoints.INDIA_ALL_DATA)
    fun getIndiaAllDataAsync(): Deferred<Response<IndiaData>>

    @GET(EndPoints.INDIA_STATE_DISTRICT_WISE_DATA)
    fun getAllStateDataAsync(): Deferred<Response<StateWiseDataResponseV2>>

    @GET(EndPoints.INDIA_UPDATE_LOG)
    fun getAllNotificationAsync(): Deferred<Response<NotificationList>>
}