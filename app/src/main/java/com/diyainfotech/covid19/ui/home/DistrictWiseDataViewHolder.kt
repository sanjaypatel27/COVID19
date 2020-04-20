package com.diyainfotech.covid19.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.api.india.District
import com.diyainfotech.covid19.databinding.DistrictWiseDataCellBinding

class DistrictWiseDataViewHolder(private val binding: DistrictWiseDataCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindStateData(district: District) {
        binding.districtName.text = district.district
        binding.txtConfirmedCase.text = "${district.confirmed}"
    }
}

