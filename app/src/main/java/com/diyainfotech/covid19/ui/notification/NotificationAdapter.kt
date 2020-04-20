package com.diyainfotech.covid19.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.api.india.notification.Notification

class NotificationAdapter : RecyclerView.Adapter<NotificationViewHolder>() {

    lateinit var notificationList: MutableList<Notification>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.update.text = notificationList[position].update
        holder.timestamp.text = notificationList[position].getStringFromTimeStamp()
    }

    override fun getItemCount(): Int {
        return notificationList.size

    }
}