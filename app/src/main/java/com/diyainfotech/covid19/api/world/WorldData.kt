package com.diyainfotech.covid19.api.world

import com.google.gson.annotations.SerializedName

data class WorldData(
    val id: String,
    val displayName: String,
    val areas: List<Area>,
    val totalConfirmed: Long,
    val totalDeaths: Long,
    val totalRecovered: Long,
    val lastUpdated: String
)

data class Area(
    val id: String,
    val displayName: String,
    val areas: List<Area>,
    val totalConfirmed: Long,
    val totalDeaths: Long? = null,
    val totalRecovered: Long? = null,
    val lastUpdated: String? = null,
    val lat: Double,
    val long: Double,
    @SerializedName("parentId")
    val parentID: String
)