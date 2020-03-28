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
import com.diyainfotech.covid19.util.Utils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        homeViewModel.indiaData.observe(this, Observer {
            context?.let { it1 -> Utils.showSuccessAlerter(it1,"Data fetch Success") }
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(indiaData: IndiaData) {
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        india_state_wise_data_recyclerview.layoutManager = linearLayoutManager
        stateWiseDataIndiaAdaptor = StateWiseDataIndiaAdaptor()
        stateWiseDataIndiaAdaptor.stateList = indiaData.stateList
        india_state_wise_data_recyclerview.adapter = stateWiseDataIndiaAdaptor

    }
}
