package com.diyainfotech.covid19.api.india

import com.google.gson.annotations.SerializedName


typealias StateWiseDataResponseV2 = ArrayList<State>

data class State(
    val state: String,
    @SerializedName("districtData") val districtList: List<District>
)
