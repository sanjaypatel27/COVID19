package com.diyainfotech.covid19.api.world

import com.diyainfotech.covid19.api.EndPoints
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Covid19WorldInterface {
    @GET(EndPoints.WORLD_ALL_DATA)
    fun getWorldAllDataAsync(): Deferred<Response<WorldData>>
}