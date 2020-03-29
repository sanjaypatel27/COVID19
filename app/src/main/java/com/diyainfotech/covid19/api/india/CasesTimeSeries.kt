package com.diyainfotech.covid19.api.india

data class CasesTimeSeries(
    var dailyconfirmed : String,
    var dailydeceased : String,
    var dailyrecovered : String,
    var date : String,
    var totalconfirmed : String,
    var totaldeceased : String,
    var totalrecovered : String
)
