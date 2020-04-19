package com.diyainfotech.covid19.api.india

import com.diyainfotech.covid19.api.ApiFactory
import okhttp3.ResponseBody
import retrofit2.Response

class IndiaRepository {
    suspend fun getIndiaAllData(): IndiaData? {
        val request = ApiFactory.covid19IndiaData.getIndiaAllDataAsync()
        val response: Response<IndiaData> = request.await()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getAllStateDataAsync(): StateWiseDataResponseV2? {
        val request = ApiFactory.covid19IndiaData.getAllStateDataAsync()
        val response: Response<StateWiseDataResponseV2> = request.await()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}