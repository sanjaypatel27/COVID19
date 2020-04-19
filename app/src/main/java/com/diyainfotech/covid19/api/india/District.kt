package com.diyainfotech.covid19.api.india

data class District(
    var district: String,
    val confirmed: Long,
    val lastupdatedtime: String,
    val Delta: Delta
)
data class Delta(
    val confirmed: Long
)