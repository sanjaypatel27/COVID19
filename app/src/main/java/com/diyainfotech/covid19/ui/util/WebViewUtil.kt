package com.diyainfotech.covid19.ui.util

import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.diyainfotech.covid19.util.CustomWebView

object WebViewUtil {
    var  webViewUrl = ""

    fun setUpWebView(customWebView: CustomWebView,swipeRefresh: SwipeRefreshLayout?){
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
        customWebView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        customWebView.settings.setAppCacheEnabled(true)
        customWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        customWebView.webViewClient = WebViewClient()
        customWebView.setOnKeyListener(View.OnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK && customWebView.canGoBack()
            ) {
                customWebView.goBack()
                return@OnKeyListener true
            }
            false
        })
        customWebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress < 100) {
                    if(swipeRefresh != null) {
                        swipeRefresh.isRefreshing = true
                    }
                }
                if (newProgress == 100) {
                    if(swipeRefresh != null) {
                        swipeRefresh.isRefreshing = false
                    }
                }
            }
        }
    }

    fun loadUrlIntoWebView( webViewUrl:String,customWebView: CustomWebView){
        customWebView.loadUrl(webViewUrl)
    }
    fun loadDataWebView( webViewUrl:String,customWebView: CustomWebView){
        customWebView.loadData(webViewUrl, "text/html" , "utf-8")
    }
    fun getStringForEmbedWebView(videoId:String):String{
        return "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/$videoId\" frameborder=\"0\" allowfullscreen></iframe>"
    }

}