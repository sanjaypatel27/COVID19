package com.diyainfotech.covid19.ui.world

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.api.world.Area
import kotlinx.android.synthetic.main.fragment_home.*

class CountryDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtAreaName = itemView.findViewById(R.id.area_name) as TextView
    private val txtConfirmedCase = itemView.findViewById(R.id.txt_confirmed_case) as TextView
    private val txtRecoveredCase = itemView.findViewById(R.id.txt_recovered_case) as TextView
    private val txtDeceasedCase = itemView.findViewById(R.id.txt_deceased_case) as TextView
    private val areaCellCard = itemView.findViewById(R.id.areaCellCard) as CardView
    private val subAreaLayout = itemView.findViewById(R.id.sub_area_layout) as RelativeLayout
    private val subAreaDataRecyclerView =
        itemView.findViewById(R.id.sub_area_recyclerView) as RecyclerView
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(itemView.context)
    private lateinit var subAreaDataAdaptor: CountryWiseDataForWorldAdaptor

    fun bindStateData(area: Area) {
        subAreaLayout.visibility = View.GONE
        txtAreaName.text = area.displayName

        txtConfirmedCase.text = "${area.totalConfirmed}"
        if (area.totalRecovered != null) {
            txtRecoveredCase.text = "${area.totalRecovered}"
        }
        if (area.totalDeaths != null) {
            txtDeceasedCase.text = "${area.totalDeaths}"
        }

        areaCellCard.setOnClickListener(View.OnClickListener {
            if (subAreaLayout.visibility == View.GONE) {
                subAreaLayout.visibility = View.VISIBLE
                subAreaDataAdaptor = CountryWiseDataForWorldAdaptor()
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                subAreaDataRecyclerView.layoutManager = linearLayoutManager
                subAreaDataAdaptor.areaList = area.areas
                subAreaDataRecyclerView.adapter = subAreaDataAdaptor
            } else {
                subAreaLayout.visibility = View.GONE
            }
        })
    }
}