package com.diyainfotech.covid19.ui.world

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diyainfotech.covid19.api.world.WorldData
import com.diyainfotech.covid19.api.world.WorldRepository
import kotlinx.coroutines.launch

class WorldViewModel : ViewModel() {

    private val worldRepository = WorldRepository()
    val worldData: MutableLiveData<WorldData?> by lazy {
        MutableLiveData<WorldData?>()
    }

    fun getWorldAllData() {
        viewModelScope.launch {
            worldData.value = worldRepository.getWorldAllData()
            WorldServiceManager.worldData = worldData.value!!
        }
    }
}