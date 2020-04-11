package com.diyainfotech.covid19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.IndiaData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment()  {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var stateWiseDataIndiaAdaptor: StateWiseDataIndiaAdaptor
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribers()
    }

    private fun subscribers() {
        homeViewModel.getIndiaAllData()
        homeViewModel.getAllStateDataAsync()
        homeViewModel.indiaData.observe(this, Observer {
            setupRecyclerview(it!!)
        })
        homeViewModel.stateDistrictWise.observe(this, Observer {
            stateWiseDataIndiaAdaptor.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerview(indiaData: IndiaData) {
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        indiaStateWiseDataRecyclerview.layoutManager = linearLayoutManager
        stateWiseDataIndiaAdaptor = StateWiseDataIndiaAdaptor()
        stateWiseDataIndiaAdaptor.stateList = indiaData.stateList.sortedByDescending { it.confirmed.toInt() }
        indiaStateWiseDataRecyclerview.adapter = stateWiseDataIndiaAdaptor
        lastUpdateTime?.text = indiaData.stateList[0].lastupdatedtime

    }
}
