package com.diyainfotech.covid19.ui.world

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.api.world.Area
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import kotlin.properties.Delegates

class CountryWiseDataForWorldAdaptor : RecyclerView.Adapter<CountryDataViewHolder>() {

    var areaList: List<Area> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDataViewHolder {
        val inflatedView = parent.inflate(R.layout.country_wise_data_cell, false)
        return CountryDataViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return areaList.size
    }

    override fun onBindViewHolder(holder: CountryDataViewHolder, position: Int) {
        holder.bindStateData(areaList[position])
    }

}