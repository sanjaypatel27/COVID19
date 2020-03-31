package com.diyainfotech.covid19.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.util.CustomWebView


class GujaratFragment : Fragment() {

    lateinit var  customWebView :CustomWebView
    lateinit var  progressBar: ProgressBar
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
        progressBar = view.findViewById(R.id.progressBar)

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

        customWebView.loadUrl("https://gujcovid19.gujarat.gov.in/")
        customWebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress < 100) {
                    progressBar.progress =newProgress
                    progressBar.visibility = View.VISIBLE
                }
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }
            }
        }

    }
}
