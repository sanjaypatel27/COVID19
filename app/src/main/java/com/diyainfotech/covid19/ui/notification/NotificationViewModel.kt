package com.diyainfotech.covid19.ui.notification

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diyainfotech.covid19.api.india.notification.NotificationList
import kotlinx.coroutines.launch

class NotificationViewModel : ViewModel() {

    private val notificationRepository = NotificationRepository()
    val notificationList: MutableLiveData<NotificationList?> by lazy {
        MutableLiveData<NotificationList?>()
    }

    fun getAllNotification() {
        viewModelScope.launch {
            notificationList.value = notificationRepository.getAllNotification()
        }
    }

}

