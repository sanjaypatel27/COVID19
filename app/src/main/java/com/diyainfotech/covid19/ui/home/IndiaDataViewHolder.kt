package com.diyainfotech.covid19.ui.home

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.api.india.StateWise
import com.diyainfotech.covid19.databinding.IndiaDataCellBinding

class IndiaDataViewHolder(private val binding: IndiaDataCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(itemView.context)
    private var districtWiseDataAdaptor = DistrictWiseDataAdaptor()


    @SuppressLint("SetTextI18n")
    fun bindIndiaData(stateWise: StateWise) {
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.districtWiseDataRecyclerView.layoutManager = linearLayoutManager
        binding.districtLayout.visibility = View.GONE
        binding.stateName.text = stateWise.state
        binding.txtConfirmedCase.text = stateWise.confirmed
        binding.txtActiveCase.text = stateWise.active
        binding.txtRecoveredCase.text = stateWise.recovered
        binding.txtDeceasedCase.text = stateWise.deaths

        stateWise.let {
            if (stateWise.deltaconfirmed.toInt() > 0) {
                binding.txtConfirmedCaseDelta.text = "[+${stateWise.deltaconfirmed}]"
            }
            if (stateWise.deltarecovered.toInt() > 0) {
                binding.txtRecoveredCaseDelta.text = "[+${stateWise.deltarecovered}]"
            }
            if (stateWise.deltadeaths.toInt() > 0) {
                binding.txtDeceasedCaseDelta.text = "[+${stateWise.deltadeaths}]"
            }

            binding.stateCellCard.setOnClickListener(View.OnClickListener {
                if (binding.districtLayout.visibility == View.GONE) {
                    binding.districtLayout.visibility = View.VISIBLE
                    districtWiseDataAdaptor.districtList =
                        IndiaDataServiceManager.getDistrictListFromDistrictData(stateWise.state)
                    if (districtWiseDataAdaptor.districtList.isNotEmpty()) {
                        binding.districtWiseDataRecyclerView.adapter = districtWiseDataAdaptor
                    } else {
                        binding.districtLayout.visibility = View.GONE
                    }
                } else {
                    binding.districtLayout.visibility = View.GONE
                }
            })
        }
    }
}