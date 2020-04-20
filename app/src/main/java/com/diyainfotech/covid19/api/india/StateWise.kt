package com.diyainfotech.covid19.api.india

data  class StateWise (
    var active : String,
    var confirmed : String,
    var deaths : String,
    var lastupdatedtime : String,
    var recovered : String,
    var state : String,
    var deltaconfirmed : String,
    var deltadeaths : String,
    var deltarecovered : String,
    var statecode : String,
    var statenotes : String
)