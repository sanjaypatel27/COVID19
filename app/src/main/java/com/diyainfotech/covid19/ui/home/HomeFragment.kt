package com.diyainfotech.covid19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.IndiaData

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var stateWiseDataIndiaAdaptor: StateWiseDataIndiaAdaptor
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var indiaStateWiseDataRecyclerview: RecyclerView
    private lateinit var lastUpdateTime: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indiaStateWiseDataRecyclerview = view.findViewById(R.id.indiaStateWiseDataRecyclerview)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        indiaStateWiseDataRecyclerview.layoutManager = linearLayoutManager

        lastUpdateTime = view.findViewById(R.id.lastUpdateTime)
        swipeRefresh = view.findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        subscribers()
        swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadData(true)
        })
    }

    private fun loadData(isReload: Boolean) {
        swipeRefresh.isRefreshing = true

        if (isReload) {
            stateWiseDataIndiaAdaptor.stateList = emptyList()
            stateWiseDataIndiaAdaptor.notifyDataSetChanged()
            homeViewModel.getIndiaAllData()
            homeViewModel.getAllStateDataAsync()
        } else {
            if (IndiaDataServiceManager.indiaData == null) {
                homeViewModel.getIndiaAllData()
                homeViewModel.getAllStateDataAsync()
            } else {
                setupRecyclerview(IndiaDataServiceManager.indiaData!!)
            }
        }
    }

    private fun subscribers() {
        loadData(false)
        homeViewModel.indiaData.observe(viewLifecycleOwner, Observer {
            IndiaDataServiceManager.indiaData = it!!
            setupRecyclerview(it!!)
        })
        homeViewModel.stateDistrictWise.observe(viewLifecycleOwner, Observer {
            IndiaDataServiceManager.stateDistrictWise = it!!
            stateWiseDataIndiaAdaptor.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerview(indiaData: IndiaData) {
        swipeRefresh.isRefreshing = false
        stateWiseDataIndiaAdaptor = StateWiseDataIndiaAdaptor()
        stateWiseDataIndiaAdaptor.stateList =
            indiaData.stateList.sortedByDescending { it.confirmed.toInt() }
        indiaStateWiseDataRecyclerview.adapter = stateWiseDataIndiaAdaptor
        lastUpdateTime.text = indiaData.stateList[0].lastupdatedtime
    }
}
