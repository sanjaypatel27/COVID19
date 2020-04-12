package com.diyainfotech.covid19.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TimeDiffUtil {
    private const val lastUpdatedDateTimeZoneFormat = "EEE, d MMM yyyy HH:mm:ss Z"

    @SuppressLint("SimpleDateFormat")
    fun getLastUpdateTime(date : String) : String{

        val nowCalendar = Calendar.getInstance()
        nowCalendar.timeZone = TimeZone.getTimeZone("GMT")

        val lastUpdateCalendar = Calendar.getInstance()
        nowCalendar.timeZone = TimeZone.getTimeZone("GMT")

        val  now = nowCalendar.time

        val lastUpdateDateAndTime  = (SimpleDateFormat(lastUpdatedDateTimeZoneFormat).parse(date))
       lastUpdateCalendar.time = lastUpdateDateAndTime!!
        val past = lastUpdateCalendar.time

        val seconds = TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(now.time - past.time)
        val hours = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
        val day = TimeUnit.MILLISECONDS.toDays(now.time - past.time)

        return when {
            seconds < 60 -> {
                "Few seconds ago"
            }
            minutes < 60 -> {
                "$minutes minutes ago"
            }
            hours < 24 -> {
                "$hours hour ${minutes % 60} min ago"
            }
            day < 31 -> {
                "$day day ago"
            }
            else -> {
                SimpleDateFormat(lastUpdatedDateTimeZoneFormat).format(past).toString()
            }
        }
    }
}