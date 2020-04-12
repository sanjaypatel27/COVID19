package com.diyainfotech.covid19.ui.news

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.extensions.autoNotify
import com.diyainfotech.covid19.extensions.inflate
import com.diyainfotech.covid19.rssFeedParser.Article
import kotlin.properties.Delegates

class NewsAdaptor : RecyclerView.Adapter<NewsViewHolder>() {
    var articleList: List<Article> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.title == n.title }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflatedView = parent.inflate(R.layout.news_view_cell, false)
        return NewsViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(articleList[position])
    }
}