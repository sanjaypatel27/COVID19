package com.diyainfotech.covid19.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.KeyValues
import com.diyainfotech.covid19.api.india.StateWise

class IndiaDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtConfirmedCase = itemView.findViewById(R.id.txt_confirmed_case) as TextView
    private val txtConfirmedCaseDelta =
        itemView.findViewById(R.id.txt_confirmed_case_delta) as TextView
    private val txtActiveCase = itemView.findViewById(R.id.txt_active_case) as TextView
    private val txtActiveCaseDelta = itemView.findViewById(R.id.txt_active_case_delta) as TextView
    private val txtRecoveredCase = itemView.findViewById(R.id.txt_recovered_case) as TextView
    private val txtRecoveredCaseDelta =
        itemView.findViewById(R.id.txt_recovered_case_delta) as TextView
    private val txtDeceasedCase = itemView.findViewById(R.id.txt_deceased_case) as TextView
    private val txtDeceasedCaseDelta =
        itemView.findViewById(R.id.txt_deceased_case_delta) as TextView

    fun bindIndiaData(stateWise: StateWise) {
        txtConfirmedCase.text = stateWise.confirmed
        txtActiveCase.text = stateWise.active
        txtRecoveredCase.text = stateWise.recovered
        txtDeceasedCase.text = stateWise.deaths

        stateWise.let {
            if (stateWise.confirmed.toInt() > 0) {
                txtConfirmedCaseDelta.text = "[+${stateWise.deltaconfirmed}]"
            }
            if (stateWise.recovered.toInt() > 0) {
                txtRecoveredCaseDelta.text = "[+${stateWise.deltarecovered}]"
            }
            if (stateWise.deaths.toInt() > 0) {
                txtDeceasedCaseDelta.text = "[+${stateWise.deltadeaths}]"
            }
        }
    }
}