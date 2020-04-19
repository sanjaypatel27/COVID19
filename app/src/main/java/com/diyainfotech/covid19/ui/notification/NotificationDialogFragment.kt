package com.diyainfotech.covid19.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.api.india.notification.NotificationList
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_notification_dialog.*

class NotificationDialogFragment : BottomSheetDialogFragment() {

    private val notificationViewModel: NotificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_notification_dialog,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.layoutManager = LinearLayoutManager(context)
        subscribers()
    }

    private fun subscribers() {
        notificationViewModel.getAllNotification()

        notificationViewModel.notificationList.observe(this, Observer {
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(notificationList: NotificationList) {
        val notificationAdapter = NotificationAdapter()
        notificationAdapter.notificationList = notificationList.asReversed()
        list.adapter = notificationAdapter

    }

    companion object {
        fun newInstance(): NotificationDialogFragment =
            NotificationDialogFragment()

    }
}
