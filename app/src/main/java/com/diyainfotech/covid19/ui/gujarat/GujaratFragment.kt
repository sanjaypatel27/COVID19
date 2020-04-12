package com.diyainfotech.covid19.ui.news

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.ui.util.WebViewUtil
import com.diyainfotech.covid19.util.CustomWebView


class GujaratFragment : Fragment() {

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
        customWebView = view.findViewById(R.id.customWebView)
        swipeRefresh = view.findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        WebViewUtil.setUpWebView(customWebView, swipeRefresh)
        loadUrl()

        swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadUrl()
        })
    }

    private fun loadUrl() {
        WebViewUtil.loadUrlIntoWebView(Constant.gujaratWebViewUrl, customWebView)
    }

}
