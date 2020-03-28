package com.diyainfotech.covid19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.util.Utils

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

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
        })
    }
}
