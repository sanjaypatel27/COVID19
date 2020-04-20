package com.diyainfotech.covid19.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diyainfotech.covid19.rssFeedParser.Channel
import com.diyainfotech.covid19.rssFeedParser.Parser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsUrl = "https://www.bhaskar.com/rss-feed/1061/"
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private lateinit var articleListLive: MutableLiveData<Channel>

    fun getArticleList(): MutableLiveData<Channel> {
        if (!::articleListLive.isInitialized) {
            articleListLive = MutableLiveData()
        }
        return articleListLive
    }
    private fun setChannel(channel: Channel) {
        articleListLive.postValue(channel)
    }
    fun fetchFeed() {
        coroutineScope.launch(Dispatchers.Main) {
            try {
                val parser = Parser()
                val articleList = parser.getChannel(newsUrl)
                setChannel(articleList)
            } catch (e: Exception) {
                e.printStackTrace()
                setChannel(Channel(null, null, null, null, null, null, mutableListOf()))
            }
        }
    }
}