package com.diyainfotech.covid19.ui.home

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.District
import com.diyainfotech.covid19.api.india.StateWise

class DistrictWiseDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtDistrictName = itemView.findViewById(R.id.district_name) as TextView
    private val txtConfirmedCase = itemView.findViewById(R.id.txt_confirmed_case) as TextView

    fun bindStateData(district: District) {
        txtDistrictName.text = district.name
        txtConfirmedCase.text = "${district.confirmed}"
    }
}

