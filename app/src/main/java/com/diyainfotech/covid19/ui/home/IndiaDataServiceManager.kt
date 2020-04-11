package com.diyainfotech.covid19.ui.home

import com.diyainfotech.covid19.api.india.District
import com.diyainfotech.covid19.api.india.DistrictData
import com.diyainfotech.covid19.api.india.IndiaData
import com.diyainfotech.covid19.api.india.StateWiseDataResponse

object IndiaDataServiceManager {
    lateinit  var indiaData: IndiaData
    lateinit var stateDistrictWise: StateWiseDataResponse

    private fun getDistrictDataBasedOnString(stateName: String): DistrictData {
        when (stateName) {
            "Kerala" -> return stateDistrictWise!!.kerala
            "Delhi" -> return stateDistrictWise!!.delhi
            "Telangana" -> return stateDistrictWise!!.telangana
            "Rajasthan" -> return stateDistrictWise!!.rajasthan
            "Haryana" -> return stateDistrictWise!!.haryana
            "Uttar Pradesh" -> return stateDistrictWise!!.uttarPradesh
            "Ladakh" -> return stateDistrictWise!!.ladakh
            "Tamil Nadu" -> return stateDistrictWise!!.tamilNadu
            "Jammu and Kashmir" -> return stateDistrictWise!!.jammuAndKashmir
            "Maharashtra" -> return stateDistrictWise!!.maharashtra
            "Karnataka" -> return stateDistrictWise!!.karnataka
            "Punjab" -> return stateDistrictWise!!.punjab
            "Andhra Pradesh" -> return stateDistrictWise!!.andhraPradesh
            "Uttarakhand" -> return stateDistrictWise!!.uttarakhand
            "Odisha" -> return stateDistrictWise!!.odisha
            "Puducherry" -> return stateDistrictWise!!.puducherry
            "West Bengal" -> return stateDistrictWise!!.westBengal
            "Chandigarh" -> return stateDistrictWise!!.chandigarh
            "Chhattisgarh" -> return stateDistrictWise!!.chhattisgarh
            "Gujarat" -> return stateDistrictWise!!.gujarat
            "Himachal Pradesh" -> return stateDistrictWise!!.himachalPradesh
            "Madhya Pradesh" -> return stateDistrictWise!!.madhyaPradesh
            "Bihar" -> return stateDistrictWise!!.bihar
            "Manipur" -> return stateDistrictWise!!.manipur
            "Mizoram" -> return stateDistrictWise!!.mizoram
            "Goa" -> return stateDistrictWise!!.goa
            "Jharkhand" -> return stateDistrictWise!!.jharkhand
            "Assam" -> return stateDistrictWise!!.assam
            "Tripura" -> return stateDistrictWise!!.tripura
            "Sikkim" -> return stateDistrictWise!!.sikkim
            "Nagaland" -> return stateDistrictWise!!.nagaland
            "Meghalaya" -> return stateDistrictWise!!.meghalaya
            "Lakshadweep" -> return stateDistrictWise!!.lakshadweep
            "Daman and Diu" -> return stateDistrictWise!!.damanAndDiu
            "Dadra and Nagar Haveli" -> return stateDistrictWise!!.dadraAndNagarHaveli
            "Arunachal Pradesh" -> return stateDistrictWise!!.arunachalPradesh
            "Andaman and Nicobar Islands" -> return stateDistrictWise!!.andamanAndNicobarIslands
            else -> return stateDistrictWise!!.unknown
        }
    }

    fun getDistrictListFromDistrictData(stateName: String): List<District> {
        val districtData = getDistrictDataBasedOnString(stateName)
        val districtList: MutableList<District> = ArrayList()
        if(districtData != null) {
            for ((districtName, district) in districtData.districtData) {
                district.name = districtName
                districtList.add(district)
            }
            return districtList.sortedBy { it.name }
        }
        return districtList
    }
}