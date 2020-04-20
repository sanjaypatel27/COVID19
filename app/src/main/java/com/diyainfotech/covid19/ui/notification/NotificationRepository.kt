package com.diyainfotech.covid19.ui.notification

import com.diyainfotech.covid19.api.ApiFactory
import com.diyainfotech.covid19.api.india.notification.NotificationList
import retrofit2.Response

class NotificationRepository {
    suspend fun getAllNotification(): NotificationList? {
        val request = ApiFactory.covid19NotificationList.getAllNotificationAsync()
        val response: Response<NotificationList> = request.await()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}