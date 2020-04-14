package com.diyainfotech.covid19.ui.news

import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.api.loadAny
import com.diyainfotech.covid19.Constant
import com.diyainfotech.covid19.DeveloperKey
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.rssFeedParser.Article
import com.diyainfotech.covid19.util.TimeDiffUtil
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView

class NewsViewHolder(itemView: View, private val onNewsCardClickListener: OnNewsCardClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener, YouTubeThumbnailView.OnInitializedListener , YouTubeThumbnailLoader.OnThumbnailLoadedListener {
    private val newsCard = itemView.findViewById(R.id.newsCard) as CardView
    private val title = itemView.findViewById(R.id.title) as TextView
    private val description = itemView.findViewById(R.id.description) as TextView
    private val source = itemView.findViewById(R.id.source) as TextView
    private val publishDate = itemView.findViewById(R.id.publishDate) as TextView
    private val articleImage = itemView.findViewById(R.id.articleImage) as ImageView
    private val sourceFavicon = itemView.findViewById(R.id.sourceFavicon) as ImageView
    private val youTubeThumbnailView =
        itemView.findViewById(R.id.youTubeThumbnailView) as YouTubeThumbnailView
    private lateinit var youTubeThumbnailLoader : YouTubeThumbnailLoader
    private lateinit var article: Article


    fun bindData(article: Article) {
        source.setOnClickListener(this)
        newsCard.setOnClickListener(this)
        this.article = article
        title.text = article.title
        if (article.description != null) {
            description.text = (HtmlCompat.fromHtml(article.description!!, 0))
        }
        Log.d("Sanjay", "Link : \n ${article.link}")
        source.text = article.link
        publishDate.text = TimeDiffUtil.getLastUpdateTime(
            article.pubDate!!,
            Constant.newsLastUpdatedDateTimeZoneFormat
        )

        if (!TextUtils.isEmpty(article.link)) {
            sourceFavicon.loadAny(Constant.getFaviconFromSiteURL + article.link)
            if (article.link!!.contains("youtube")) {
                articleImage.visibility = View.GONE
                youTubeThumbnailView.visibility = View.GONE
                youTubeThumbnailView.initialize(DeveloperKey.DEVELOPER_KEY, this)
            } else {
                articleImage.visibility = View.VISIBLE
                youTubeThumbnailView.visibility = View.GONE
                if (!TextUtils.isEmpty(article.image)) {
                    articleImage.load(article.image)
                }
            }
        }

    }


    override fun onClick(v: View?) {
        when {
            v!!.id == R.id.source -> {
                onNewsCardClickListener.onNewsCardSourceLinkClick(article)
            }
            v.id == R.id.newsCard -> {
                onNewsCardClickListener.onNewsCardClick(article)
            }
        }
    }

    override fun onInitializationSuccess(p0: YouTubeThumbnailView?, p1: YouTubeThumbnailLoader?) {
        if (p1 != null) {
            youTubeThumbnailLoader = p1
            youTubeThumbnailLoader.setOnThumbnailLoadedListener(this)
            var videoId = article.link!!.split("v=")[1]
            youTubeThumbnailLoader.setVideo(videoId)
        }
    }

    override fun onInitializationFailure(
        p0: YouTubeThumbnailView?,
        p1: YouTubeInitializationResult?
    ) {
    }

    override fun onThumbnailLoaded(p0: YouTubeThumbnailView?, p1: String?) {
        youTubeThumbnailView.visibility = View.VISIBLE
    }

    override fun onThumbnailError(
        p0: YouTubeThumbnailView?,
        p1: YouTubeThumbnailLoader.ErrorReason?
    ) {
    }
}