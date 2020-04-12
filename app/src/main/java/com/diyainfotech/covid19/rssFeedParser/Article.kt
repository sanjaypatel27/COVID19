package com.diyainfotech.covid19.rssFeedParser

data class Article(
    var guid: String? = null,
    var title: String? = null,
    var author: String? = null,
    var link: String? = null,
    var pubDate: String? = null,
    var description: String? = null,
    var content: String? = null,
    var image: String? = null,
    var audio: String? = null,
    var sourceName: String? = null,
    var sourceUrl: String? = null,
    private var _categories: MutableList<String> = mutableListOf()
) {

    val categories: MutableList<String>
        get() = _categories

    fun addCategory(category: String) {
        _categories.add(category)
    }
}
