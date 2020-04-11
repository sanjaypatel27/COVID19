package com.diyainfotech.covid19.ui.news

import android.os.Bundle
import android.view.*
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.util.CustomWebView


class GujaratFragment : Fragment(){

    lateinit var customWebView: CustomWebView
    lateinit var swipeRefresh: SwipeRefreshLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customWebView = view.findViewById(R.id.gujaratWebView)
        swipeRefresh = view.findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(R.color.colorAccent)

        customWebView.settings.javaScriptEnabled = true
        customWebView.settings.setSupportZoom(true)
        customWebView.settings.builtInZoomControls = true
        customWebView.settings.displayZoomControls = false
        customWebView.settings.useWideViewPort = true
        customWebView.settings.loadWithOverviewMode = true
        customWebView.settings.domStorageEnabled = true
        customWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        customWebView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        customWebView.isScrollbarFadingEnabled = false
        customWebView.isVerticalScrollBarEnabled = false
        customWebView.settings.setGeolocationEnabled(true)
        customWebView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        customWebView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        customWebView.settings.setAppCacheEnabled(true)
        customWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        customWebView.webViewClient = WebViewClient()

        loadUrl()
        customWebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress < 100) {
                    swipeRefresh.isRefreshing = true
                }
                if (newProgress == 100) {
                    swipeRefresh.isRefreshing = false
                }
            }
        }
        customWebView.setOnKeyListener(View.OnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK && customWebView.canGoBack()
            ) {
                customWebView.goBack()
                return@OnKeyListener true
            }
            false
        })

        swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadUrl()
        })
    }

    private fun loadUrl() {
        customWebView.loadUrl("https://gujcovid19.gujarat.gov.in/")
    }

}
