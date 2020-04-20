package com.diyainfotech.covid19.ui.gujarat

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.databinding.FragmentWebviewBinding
import com.diyainfotech.covid19.ui.util.WebViewUtil
import com.diyainfotech.covid19.util.CustomWebView


class GujaratFragment : Fragment() {

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
        WebViewUtil.loadUrlIntoWebView(Constant.gujaratWebViewUrl, binding.customWebView)
    }

}
