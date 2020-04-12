package com.diyainfotech.covid19.ui.news

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
import com.diyainfotech.covid19.rssFeedParser.Channel

class NewsFragment : Fragment() {
    private val newsViewModel: NewsViewModel by viewModels()
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsAdaptor: NewsAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsRecyclerView = view.findViewById(R.id.newsRecyclerView)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        newsRecyclerView.layoutManager = linearLayoutManager
        subscribers()
    }

    private fun subscribers() {
        newsViewModel.fetchFeed()

        newsViewModel.getArticleList().observe(viewLifecycleOwner, Observer {
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(channel: Channel) {
        newsAdaptor = NewsAdaptor()
        newsAdaptor.articleList =
            channel.articles
        newsRecyclerView.adapter = newsAdaptor
    }
}
