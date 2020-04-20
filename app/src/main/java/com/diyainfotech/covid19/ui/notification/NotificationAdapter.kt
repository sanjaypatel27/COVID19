package com.diyainfotech.covid19.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.api.india.notification.Notification
import com.diyainfotech.covid19.databinding.NotificationCellBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationViewHolder>() {

    lateinit var notificationList: MutableList<Notification>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NotificationViewHolder(
        NotificationCellBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun getItemCount(): Int {
       return  notificationList.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
            holder.bindData(notificationList[position])
    }


}