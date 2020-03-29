package com.diyainfotech.covid19.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.StateWise

class StateWiseDataVIewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtStateName = itemView.findViewById(R.id.state_name) as TextView
    private val txtConfirmedCase = itemView.findViewById(R.id.txt_confirmed_case) as TextView
    private val txtActiveCase = itemView.findViewById(R.id.txt_active_case) as TextView
    private val txtRecoveredCase = itemView.findViewById(R.id.txt_recovered_case) as TextView
    private val txtDeceasedCase = itemView.findViewById(R.id.txt_deceased_case) as TextView
    fun bindStateData(stateWise: StateWise){
        if(stateWise.state == "Total"){
            txtStateName.text = "INDIA"
        }else{
            txtStateName.text = stateWise.state
        }
        txtConfirmedCase.text = stateWise.confirmed
        txtActiveCase.text = stateWise.active
        txtRecoveredCase.text = stateWise.recovered
        txtDeceasedCase.text = stateWise.deaths
    }
}