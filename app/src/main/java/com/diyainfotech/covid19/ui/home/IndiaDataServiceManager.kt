package com.diyainfotech.covid19.ui.home

import com.diyainfotech.covid19.api.india.IndiaData
import com.diyainfotech.covid19.api.india.StateWiseDataResponse

object IndiaDataServiceManager {
    var indiaData: IndiaData ? = null
    var stateDistrictWise: StateWiseDataResponse? = null
}