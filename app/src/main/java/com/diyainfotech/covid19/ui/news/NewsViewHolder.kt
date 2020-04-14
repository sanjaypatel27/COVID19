package com.diyainfotech.covid19.ui.news

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
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.rssFeedParser.Article
import com.diyainfotech.covid19.util.TimeDiffUtil

class NewsViewHolder(itemView: View, private val onNewsCardClickListener: OnNewsCardClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val newsCard = itemView.findViewById(R.id.newsCard) as CardView
    private val title = itemView.findViewById(R.id.title) as TextView
    private val description = itemView.findViewById(R.id.description) as TextView
    private val source = itemView.findViewById(R.id.source) as TextView
    private val publishDate = itemView.findViewById(R.id.publishDate) as TextView
    private val articleImage = itemView.findViewById(R.id.articleImage) as ImageView
    private val sourceFavicon = itemView.findViewById(R.id.sourceFavicon) as ImageView
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
        if (article.image != null) {
            articleImage.load(article.image)
        }
        if (article.link != null) {
            sourceFavicon.loadAny(Constant.getFaviconFromSiteURL + article.link){
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
}