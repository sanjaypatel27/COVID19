package com.diyainfotech.covid19.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.databinding.IndiaDataCellBinding
import com.diyainfotech.covid19.databinding.NewsViewCellBinding
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import com.diyainfotech.covid19.ui.news.NewsViewHolder
import kotlin.properties.Delegates

class StateWiseDataIndiaAdaptor() : RecyclerView.Adapter<IndiaDataViewHolder>() {

    var stateList: List<StateWise> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.state == n.state }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IndiaDataViewHolder(
        IndiaDataCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return stateList.size
    }

    override fun onBindViewHolder(holder: IndiaDataViewHolder, position: Int) {
        holder.bindIndiaData(stateList[position])

    }
}