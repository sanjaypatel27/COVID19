package com.diyainfotech.covid19.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import kotlin.properties.Delegates

class StateWiseDataIndiaAdaptor() : RecyclerView.Adapter<StateWiseDataVIewHolder>() {
    var stateList: List<StateWise> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.state == n.state }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateWiseDataVIewHolder {
        val inflatedView = parent.inflate(R.layout.state_wise_data_cell, false)
        return StateWiseDataVIewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    override fun onBindViewHolder(holder: StateWiseDataVIewHolder, position: Int) {
        holder.bindStateData(stateList.get(position))
    }
    private fun orderListInMoreThenOne() : Boolean{
        if(stateList.isNotEmpty() && stateList.size > 1) {
            return true
        }
        return false
    }
}