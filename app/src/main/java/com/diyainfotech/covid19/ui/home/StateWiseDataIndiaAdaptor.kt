package com.diyainfotech.covid19.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import kotlin.properties.Delegates

class StateWiseDataIndiaAdaptor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var stateList: List<StateWise> by Delegates.observable(emptyList()) {
        prop, old, new ->
        autoNotify(old, new) { o, n -> o.state == n.state }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == Constant.cellTypeIndia){
            val inflatedView = parent.inflate(R.layout.india_data_cell, false)
            return IndiaDataViewHolder(inflatedView)
        }
        val inflatedView = parent.inflate(R.layout.state_wise_data_cell, false)
        return StateWiseDataViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is StateWiseDataViewHolder) {
            holder.bindStateData(stateList[position])
        }else if (holder is IndiaDataViewHolder){
            holder.bindIndiaData(stateList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
       if(position == 0){
           return Constant.cellTypeIndia
       }
        return Constant.cellTypeState
    }

}