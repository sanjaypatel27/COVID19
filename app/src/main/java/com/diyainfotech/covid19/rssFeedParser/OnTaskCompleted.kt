package com.diyainfotech.covid19.rssFeedParser

interface OnTaskCompleted {
    fun onTaskCompleted(channel: Channel)
    fun onError(e: Exception)
}