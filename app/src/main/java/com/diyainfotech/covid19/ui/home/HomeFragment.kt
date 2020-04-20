package com.diyainfotech.covid19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.IndiaData
import com.diyainfotech.covid19.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var stateWiseDataIndiaAdaptor: StateWiseDataIndiaAdaptor
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.indiaStateWiseDataRecyclerview.layoutManager = linearLayoutManager

        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        subscribers()
        binding.swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadData(true)
        })
    }

    private fun loadData(isReload: Boolean) {
        binding.swipeRefresh.isRefreshing = true

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
            setupRecyclerview(it)
        })
        homeViewModel.stateDistrictWise.observe(viewLifecycleOwner, Observer {
            IndiaDataServiceManager.stateDistrictWise = it!!
            stateWiseDataIndiaAdaptor.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerview(indiaData: IndiaData) {
        binding.swipeRefresh.isRefreshing = false
        stateWiseDataIndiaAdaptor = StateWiseDataIndiaAdaptor()
        stateWiseDataIndiaAdaptor.stateList =
            indiaData.stateList.sortedByDescending { it.confirmed.toInt() }
        binding.indiaStateWiseDataRecyclerview.adapter = stateWiseDataIndiaAdaptor
        binding.lastUpdateTime.text = indiaData.stateList[0].lastupdatedtime
    }
}
