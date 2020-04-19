package com.diyainfotech.covid19.api.india

import com.google.gson.annotations.SerializedName

class IndiaData {
    @SerializedName("cases_time_series")
    lateinit var casesTimeSeriesList : ArrayList<CasesTimeSeries>
    @SerializedName("statewise")
    lateinit var stateList : ArrayList<StateWise>
}