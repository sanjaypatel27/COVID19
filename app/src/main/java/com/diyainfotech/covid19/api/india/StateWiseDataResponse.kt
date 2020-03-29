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

    @SerializedName("Andaman and Nicobar Islands")
    val andamanAndNicobarIslands: DistrictData,

    @SerializedName("Unknown")
    val unknown: DistrictData
) {
    override fun toString(): String {
        return "StateWiseDataResponse(" +
                "\nkerala=$kerala," +
                " \ndelhi=$delhi," +
                " \ntelangana=$telangana, " +
                "\nrajasthan=$rajasthan," +
                " \nharyana=$haryana," +
                " \nuttarPradesh=$uttarPradesh, " +
                "\nladakh=$ladakh," +
                " \ntamilNadu=$tamilNadu," +
                " \njammuAndKashmir=$jammuAndKashmir," +
                "\nmaharashtra=$maharashtra, " +
                "\npunjab=$punjab," +
                " \nandhraPradesh=$andhraPradesh," +
                "\nuttarakhand=$uttarakhand," +
                " \nodisha=$odisha, " +
                "\npuducherry=$puducherry, " +
                "\nwestBengal=$westBengal, " +
                "\nchandigarh=$chandigarh, " +
                "\nchhattisgarh=$chhattisgarh, " +
                "\ngujarat=$gujarat," +
                " \nhimachalPradesh=$himachalPradesh, " +
                "\nmadhyaPradesh=$madhyaPradesh," +
                " \nbihar=$bihar, \nmanipur=$manipur, " +
                "\nmizoram=$mizoram," +
                " \ngoa=$goa," +
                " \nandamanAndNicobarIslands=$andamanAndNicobarIslands," +
                "\nunknown=$unknown)"
    }
}
data class DistrictData (

    val districtData: Map<String, District>
) {
    override fun toString(): String {
        return "\n{districtData=$districtData)"
    }
}

data class District (
    var name: String,
    val confirmed: Long,
    val lastupdatedtime: String
) {
    override fun toString(): String {
        return "\n{District(\nconfirmed=$confirmed, \nlastupdatedtime='$lastupdatedtime')"
    }
}