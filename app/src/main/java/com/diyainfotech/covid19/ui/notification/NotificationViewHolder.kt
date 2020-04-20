package com.diyainfotech.covid19.ui.notification

import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.api.india.notification.Notification
import com.diyainfotech.covid19.databinding.NotificationCellBinding


class NotificationViewHolder(private val notificationCellBinding: NotificationCellBinding) :
    RecyclerView.ViewHolder(notificationCellBinding.root) {
    fun bindData(notification: Notification) {
        notificationCellBinding.update.text = notification.update
        notificationCellBinding.timestamp.text = notification.getStringFromTimeStamp()
    }
}