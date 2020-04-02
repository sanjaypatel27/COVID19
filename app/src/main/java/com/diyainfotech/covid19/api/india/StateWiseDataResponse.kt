package com.diyainfotech.covid19.api.india

import com.google.gson.annotations.SerializedName


data class StateWiseDataResponse(

    @SerializedName("Kerala")
    val kerala: DistrictData,

    @SerializedName("Delhi")
    val delhi: DistrictData,

    @SerializedName("Telangana")
    val telangana: DistrictData,

    @SerializedName("Rajasthan")
    val rajasthan: DistrictData,

    @SerializedName("Haryana")
    val haryana: DistrictData,

    @SerializedName("Uttar Pradesh")
    val uttarPradesh: DistrictData,

    @SerializedName("Ladakh")
    val ladakh: DistrictData,

    @SerializedName("Tamil Nadu")
    val tamilNadu: DistrictData,

    @SerializedName("Jammu and Kashmir")
    val jammuAndKashmir: DistrictData,

    @SerializedName("Maharashtra")
    val maharashtra: DistrictData,

    @SerializedName("Karnataka")
    val karnataka: DistrictData,

    @SerializedName("Punjab")
    val punjab: DistrictData,

    @SerializedName("Andhra Pradesh")
    val andhraPradesh: DistrictData,

    @SerializedName("Uttarakhand")
    val uttarakhand: DistrictData,

    @SerializedName("Odisha")
    val odisha: DistrictData,

    @SerializedName("Puducherry")
    val puducherry: DistrictData,

    @SerializedName("West Bengal")
    val westBengal: DistrictData,

    @SerializedName("Chandigarh")
    val chandigarh: DistrictData,

    @SerializedName("Chhattisgarh")
    val chhattisgarh: DistrictData,

    @SerializedName("Gujarat")
    val gujarat: DistrictData,

    @SerializedName("Himachal Pradesh")
    val himachalPradesh: DistrictData,

    @SerializedName("Madhya Pradesh")
    val madhyaPradesh: DistrictData,

    @SerializedName("Bihar")
    val bihar: DistrictData,

    @SerializedName("Manipur")
    val manipur: DistrictData,

    @SerializedName("Mizoram")
    val mizoram: DistrictData,

    @SerializedName("Goa")
    val goa: DistrictData,

    @SerializedName("Jharkhand")
    val jharkhand: DistrictData,

    @SerializedName("Assam")
    val assam: DistrictData,
    @SerializedName("Tripura")
    val tripura: DistrictData,

    @SerializedName("Sikkim")
    val sikkim: DistrictData,

    @SerializedName("Nagaland")
    val nagaland: DistrictData,

    @SerializedName("Meghalaya")
    val meghalaya: DistrictData,

    @SerializedName("Lakshadweep")
    val lakshadweep: DistrictData,

    @SerializedName("Daman and Diu")
    val damanAndDiu: DistrictData,

    @SerializedName("Dadra and Nagar Haveli")
    val dadraAndNagarHaveli: DistrictData,

    @SerializedName("Arunachal Pradesh")
    val arunachalPradesh: DistrictData,

    @SerializedName("Andaman and Nicobar Islands")
    val andamanAndNicobarIslands: DistrictData,

    @SerializedName("Unknown")
    val unknown: DistrictData
)

data class DistrictData(

    val districtData: Map<String, District>
)

data class District(
    var name: String,
    val confirmed: Long,
    val lastupdatedtime: String
)