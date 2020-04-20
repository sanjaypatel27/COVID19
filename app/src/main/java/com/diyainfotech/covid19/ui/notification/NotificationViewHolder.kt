package com.diyainfotech.covid19.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import kotlinx.android.synthetic.main.notification_cell.view.*


class NotificationViewHolder internal constructor(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.notification_cell,
        parent,
        false
    )
) {

    internal val update: TextView = itemView.update
    internal val timestamp: TextView = itemView.timestamp
}