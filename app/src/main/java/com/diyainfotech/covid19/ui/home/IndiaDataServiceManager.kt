package com.diyainfotech.covid19.ui.home

import com.diyainfotech.covid19.api.india.District
import com.diyainfotech.covid19.api.india.IndiaData
import com.diyainfotech.covid19.api.india.State
import com.diyainfotech.covid19.api.india.StateWiseDataResponseV2

object IndiaDataServiceManager {
    var indiaData: IndiaData? = null
    var stateDistrictWise: StateWiseDataResponseV2? = null

    private fun getDistrictDataBasedOnString(stateName: String): State? {
        val state = stateDistrictWise!!.filter { it.state.equals(stateName, true) }
        return if (state.isNotEmpty()) {
            state[0]
        } else {
            null
        }

    }

    fun getDistrictListFromDistrictData(stateName: String): List<District> {
        val state = getDistrictDataBasedOnString(stateName)
        return state?.districtList ?: ArrayList()
    }
}