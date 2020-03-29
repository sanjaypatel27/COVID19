package com.diyainfotech.covid19.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.tapadoo.alerter.Alerter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun showAlerter(context: Context, message: String) {
        Alerter.create((context as Activity)!!)
            .setBackgroundColorRes(R.color.failAlert)
            .setText(message)
            .setDuration(3000)
            .show()
    }

    fun showSuccessAlerter(context: Context, message: String) {
        Alerter.create((context as Activity))
            .setBackgroundColorRes(R.color.successAlert)
            .setText(message)
            .setDuration(3000)
            .show()
    }
}