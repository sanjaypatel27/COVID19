package com.diyainfotech.covid19.ui.world

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.world.WorldData
import kotlinx.android.synthetic.main.fragment_home.lastUpdateTime
import kotlinx.android.synthetic.main.fragment_world.*

class WorldFragment : Fragment() {

    private val worldViewModel: WorldViewModel by viewModels()
    private lateinit var countryWiseDataForWorldAdaptor: CountryWiseDataForWorldAdaptor
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_world, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribers()
    }

    private fun subscribers() {
        worldViewModel.getWorldAllData()
        worldViewModel.worldData.observe(this, Observer {
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(worldData: WorldData) {
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        worldDataRecyclerview.layoutManager = linearLayoutManager
        countryWiseDataForWorldAdaptor = CountryWiseDataForWorldAdaptor()
        countryWiseDataForWorldAdaptor.areaList = worldData.areas
        worldDataRecyclerview.adapter = countryWiseDataForWorldAdaptor
        lastUpdateTime?.text = worldData.lastUpdated
        txt_confirmed_case?.text = "${worldData.totalConfirmed}"
        txt_recovered_case?.text =  "${worldData.totalRecovered}"
        txt_deceased_case?.text =  "${worldData.totalDeaths}"
    }
}
