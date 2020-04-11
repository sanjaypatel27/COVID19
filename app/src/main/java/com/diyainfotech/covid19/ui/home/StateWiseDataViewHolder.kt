package com.diyainfotech.covid19.ui.home

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise
import kotlinx.android.synthetic.main.fragment_home.*

class StateWiseDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtStateName = itemView.findViewById(R.id.state_name) as TextView
    private val txtConfirmedCase = itemView.findViewById(R.id.txt_confirmed_case) as TextView
    private val txtConfirmedCaseDelta =
        itemView.findViewById(R.id.txt_confirmed_case_delta) as TextView
    private val txtActiveCase = itemView.findViewById(R.id.txt_active_case) as TextView
    private val txtRecoveredCase = itemView.findViewById(R.id.txt_recovered_case) as TextView
    private val txtDeceasedCase = itemView.findViewById(R.id.txt_deceased_case) as TextView
    private val stateCellCard = itemView.findViewById(R.id.stateCellCard) as CardView
    private val districtLayout = itemView.findViewById(R.id.district_layout) as RelativeLayout
    private val districtWiseDataRecyclerView =
        itemView.findViewById(R.id.district_wise_data_recyclerView) as RecyclerView
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(itemView.context)
    private lateinit var districtWiseDataAdaptor: DistrictWiseDataAdaptor

    fun bindStateData(stateWise: StateWise) {
        districtLayout.visibility= View.GONE
        txtStateName.text = stateWise.state
        txtConfirmedCase.text = stateWise.confirmed
        txtActiveCase.text = stateWise.active
        txtRecoveredCase.text = stateWise.recovered
        txtDeceasedCase.text = stateWise.deaths

        if(stateWise.deltaconfirmed.toInt() > 0) {
            txtConfirmedCaseDelta.text = "↑${stateWise.deltaconfirmed}"
        }

        stateCellCard.setOnClickListener(View.OnClickListener {
            if (districtLayout.visibility == View.GONE) {
                districtLayout.visibility = View.VISIBLE
                districtWiseDataAdaptor = DistrictWiseDataAdaptor()
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                districtWiseDataRecyclerView.layoutManager = linearLayoutManager
                districtWiseDataAdaptor.districtList = IndiaDataServiceManager.getDistrictListFromDistrictData(stateWise.state)
                districtWiseDataRecyclerView.adapter = districtWiseDataAdaptor
            } else {
                districtLayout.visibility = View.GONE
            }
        })
    }
}