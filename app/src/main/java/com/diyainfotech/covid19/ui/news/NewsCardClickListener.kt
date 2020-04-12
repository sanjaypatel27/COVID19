package com.diyainfotech.covid19.ui.news

import com.diyainfotech.covid19.rssFeedParser.Article

interface OnNewsCardClickListener{
    fun onNewsCardSourceLinkClick(article: Article)
    fun onNewsCardClick(article: Article)
}