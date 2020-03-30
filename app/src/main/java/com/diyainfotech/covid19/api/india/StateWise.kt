package com.diyainfotech.covid19.api.india

data  class StateWise (
    var active : String,
    var confirmed : String,
    var deaths : String,
    var lastupdatedtime : String,
    var recovered : String,
    var state : String,
    var delta: Delta
)