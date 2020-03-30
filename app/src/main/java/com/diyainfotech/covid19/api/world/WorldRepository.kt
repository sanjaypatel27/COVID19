package com.diyainfotech.covid19.api.world

import com.diyainfotech.covid19.api.ApiFactory
import retrofit2.Response

class WorldRepository {
    suspend fun getWorldAllData(): WorldData? {
        val request = ApiFactory.covid19WorldData.getWorldAllDataAsync()
        val response: Response<WorldData> = request.await()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}