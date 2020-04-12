package com.diyainfotech.covid19.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diyainfotech.covid19.api.world.WorldData
import com.diyainfotech.covid19.rssFeedParser.Article
import com.diyainfotech.covid19.rssFeedParser.Channel
import com.diyainfotech.covid19.rssFeedParser.Parser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel : ViewModel() {

    private val newsUrl = "https://rss.app/feeds/W3wDBmrAapsgguPK.xml"
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