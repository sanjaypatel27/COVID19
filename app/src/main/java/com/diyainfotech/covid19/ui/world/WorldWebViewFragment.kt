package com.diyainfotech.covid19.ui.world

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.databinding.FragmentWebviewBinding
import com.diyainfotech.covid19.ui.util.WebViewUtil


class WorldWebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        WebViewUtil.setUpWebView(binding.customWebView, binding.swipeRefresh)
        loadUrl()
        binding.swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadUrl()
        })
    }

    private fun loadUrl() {
        WebViewUtil.loadUrlIntoWebView(Constant.worldWebViewUrl, binding.customWebView)
    }
}
