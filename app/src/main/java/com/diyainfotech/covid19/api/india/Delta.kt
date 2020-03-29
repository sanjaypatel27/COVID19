package com.diyainfotech.covid19.api.india

data class Delta(
    val active : Long,
    val confirmed : Long,
    val deaths : Long,
    val recovered : Long
)