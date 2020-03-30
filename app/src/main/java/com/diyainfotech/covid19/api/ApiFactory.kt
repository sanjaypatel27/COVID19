package com.diyainfotech.covid19.api

import com.diyainfotech.covid19.api.RetrofitFactory.httpClient
import com.diyainfotech.covid19.api.RetrofitFactory.retrofit
import com.diyainfotech.covid19.api.india.Covid19IndiaInterface

object ApiFactory {

    val covid19IndiaData : Covid19IndiaInterface = retrofit(httpClient).create(Covid19IndiaInterface::class.java)
}