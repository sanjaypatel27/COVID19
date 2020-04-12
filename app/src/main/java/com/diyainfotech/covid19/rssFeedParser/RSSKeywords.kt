package com.diyainfotech.covid19.rssFeedParser

object RSSKeywords {

    // channel
    const val RSS_CHANNEL = "channel"
    const val RSS_CHANNEL_IMAGE = "image"
    const val RSS_CHANNEL_UPDATE_PERIOD = "sy:updatePeriod"
    const val RSS_CHANNEL_LAST_BUILD_DATE = "lastBuildDate"

    // article
    const val RSS_ITEM = "item"
    const val RSS_ITEM_TITLE = "title"
    const val RSS_ITEM_LINK = "link"
    const val RSS_ITEM_AUTHOR = "dc:creator"
    const val RSS_ITEM_CATEGORY = "category"
    const val RSS_ITEM_THUMBNAIL = "media:thumbnail"
    const val RSS_ITEM_MEDIA_CONTENT = "media:content"
    const val RSS_ITEM_ENCLOSURE = "enclosure"
    const val RSS_ITEM_DESCRIPTION = "description"
    const val RSS_ITEM_CONTENT = "content:encoded"
    const val RSS_ITEM_PUB_DATE = "pubDate"
    const val RSS_ITEM_TIME = "time"
    const val RSS_ITEM_URL = "url"
    const val RSS_ITEM_TYPE = "type"
    const val RSS_ITEM_GUID = "guid"
    const val RSS_ITEM_SOURCE = "source"
}