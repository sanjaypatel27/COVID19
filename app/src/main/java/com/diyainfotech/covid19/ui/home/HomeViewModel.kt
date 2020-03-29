package com.diyainfotech.covid19.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diyainfotech.covid19.api.india.IndiaData
import com.diyainfotech.covid19.api.india.IndiaRepository
import com.diyainfotech.covid19.api.india.StateWiseDataResponse
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val  indiaRepository = IndiaRepository()
    val indiaData: MutableLiveData<IndiaData?> by lazy {
        MutableLiveData<IndiaData?>()
    }
    val stateDistrictWise: MutableLiveData<StateWiseDataResponse?> by lazy {
        MutableLiveData<StateWiseDataResponse?>()
    }



    fun getIndiaAllData(){
        viewModelScope.launch {
            indiaData.value = indiaRepository.getIndiaAllData()
            IndiaDataServiceManager.indiaData = indiaData.value!!
        }
    }

    fun getAllStateDataAsync(){
        viewModelScope.launch {
            stateDistrictWise.value = indiaRepository.getAllStateDataAsync()
            IndiaDataServiceManager.stateDistrictWise = stateDistrictWise.value!!
        }
    }

}

