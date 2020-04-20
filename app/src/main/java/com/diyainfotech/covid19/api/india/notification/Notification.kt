package com.diyainfotech.covid19.api.india.notification

import android.annotation.SuppressLint
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.util.TimeDiffUtil
import java.text.SimpleDateFormat
import java.util.*


typealias NotificationList = ArrayList<Notification>

data class Notification(
    val update: String,
    val timestamp: Long
) {
    @SuppressLint("SimpleDateFormat")
    fun getStringFromTimeStamp(): String {
        val date = Date(timestamp * 1000L)
        val notificationTimeFormat = SimpleDateFormat(Constant.notificationDateTimeZoneFormat)
        return TimeDiffUtil.getLastUpdateTime(
            notificationTimeFormat.format(date),
            Constant.notificationDateTimeZoneFormat
        )
    }
}