package com.diyainfotech.covid19.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.District
import com.diyainfotech.covid19.databinding.DistrictWiseDataCellBinding
import com.diyainfotech.covid19.databinding.IndiaDataCellBinding
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import kotlin.properties.Delegates

class DistrictWiseDataAdaptor() : RecyclerView.Adapter<DistrictWiseDataViewHolder>() {

    var districtList: List<District> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.district == n.district }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DistrictWiseDataViewHolder(
        DistrictWiseDataCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return districtList.size
    }

    override fun onBindViewHolder(holder: DistrictWiseDataViewHolder, position: Int) {
        holder.bindStateData(districtList[position])

    }
}