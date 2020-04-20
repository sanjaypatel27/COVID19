package com.diyainfotech.covid19.ui.util

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.databinding.FragmentWebviewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: FragmentWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
    }

    private fun loadData() {
        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        WebViewUtil.setUpWebView(binding.customWebView, binding.swipeRefresh)
        loadUrl()
        binding.swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadUrl()
        })
    }

    private fun loadUrl() {
        if (!TextUtils.isEmpty(WebViewUtil.webViewUrl)) {
            WebViewUtil.loadUrlIntoWebView(WebViewUtil.webViewUrl, binding.customWebView)
        }
    }
}
