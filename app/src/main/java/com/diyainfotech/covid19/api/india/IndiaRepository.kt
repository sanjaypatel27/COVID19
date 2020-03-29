package com.diyainfotech.covid19.api.india

import com.diyainfotech.covid19.api.ApiFactory
import retrofit2.Response

class IndiaRepository {
    suspend fun getIndiaAllData(): IndiaData? {
        val request = ApiFactory.indiaData.getIndiaAllDataAsync()
        val response: Response<IndiaData> = request.await()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}