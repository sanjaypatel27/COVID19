package com.diyainfotech.covid19.api

import com.diyainfotech.covid19.api.RetrofitFactory.httpClient
import com.diyainfotech.covid19.api.RetrofitFactory.retrofit
import com.diyainfotech.covid19.api.RetrofitFactory.worldRetrofit
import com.diyainfotech.covid19.api.india.Covid19IndiaInterface
import com.diyainfotech.covid19.api.world.Covid19WorldInterface

object ApiFactory {

    val covid19IndiaData : Covid19IndiaInterface = retrofit(httpClient).create(Covid19IndiaInterface::class.java)
    val covid19WorldData : Covid19WorldInterface = worldRetrofit(httpClient).create(Covid19WorldInterface::class.java)
}