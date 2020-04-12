package com.diyainfotech.covid19

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        var application: MyApplication? = null
            private set

        val appContext: Context
            get() = application!!.applicationContext
    }
}