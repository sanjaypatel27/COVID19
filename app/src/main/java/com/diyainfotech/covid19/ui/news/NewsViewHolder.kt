package com.diyainfotech.covid19.ui.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.rssFeedParser.Article

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById(R.id.title) as TextView
    private val description = itemView.findViewById(R.id.description) as TextView
    private val source = itemView.findViewById(R.id.source) as TextView
    private val publishDate = itemView.findViewById(R.id.publishDate) as TextView
    private val articleImage = itemView.findViewById(R.id.articleImage) as ImageView

    fun bindData(article: Article) {
        title.text = article.title
        if (article.description != null) {
            description.text = (HtmlCompat.fromHtml(article.description!!, 0))
        }
        source.text = article.link
        //  publishDate.text = article.pubDate
        if (article.image != null) {
            articleImage.load(article.image)
        }

    }
}