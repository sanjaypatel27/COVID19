package com.diyainfotech.covid19.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.databinding.FragmentNewsBinding
import com.diyainfotech.covid19.rssFeedParser.Article
import com.diyainfotech.covid19.rssFeedParser.Channel
import com.diyainfotech.covid19.ui.util.WebViewActivity
import com.diyainfotech.covid19.ui.util.WebViewUtil

class NewsFragment : Fragment(), OnNewsCardClickListener {
    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel: NewsViewModel by viewModels()
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private lateinit var newsAdaptor: NewsAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.newsRecyclerView.layoutManager = linearLayoutManager
        subscribers()
    }

    private fun subscribers() {
        newsViewModel.fetchFeed()

        newsViewModel.getArticleList().observe(viewLifecycleOwner, Observer {
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(channel: Channel) {
        newsAdaptor = NewsAdaptor(this)
        newsAdaptor.articleList =
            channel.articles
        binding.newsRecyclerView.adapter = newsAdaptor
    }

    override fun onNewsCardSourceLinkClick(article: Article) {
        openWebView(article.link!!)
    }

    override fun onNewsCardClick(article: Article) {
        openWebView(article.link!!)
    }

    private fun openWebView(url: String) {
        WebViewUtil.webViewUrl = url
        val intent = Intent(activity, WebViewActivity::class.java)
        startActivity(intent)
    }
}
