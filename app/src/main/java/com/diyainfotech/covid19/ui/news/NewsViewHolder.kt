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
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.databinding.NewsViewCellBinding
import com.diyainfotech.covid19.rssFeedParser.Article
import com.diyainfotech.covid19.ui.util.WebViewUtil
import com.diyainfotech.covid19.util.CustomWebView
import com.diyainfotech.covid19.util.TimeDiffUtil

class NewsViewHolder(
    private val binding: NewsViewCellBinding,
    private val onNewsCardClickListener: OnNewsCardClickListener
) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {
    private lateinit var article: Article


    fun bindData(article: Article) {
        binding.source.setOnClickListener(this)
        binding.newsCard.setOnClickListener(this)
        this.article = article
        binding.title.text = article.title
        if (article.description != null) {
            binding.description.text = (HtmlCompat.fromHtml(article.description!!, 0))
        }
        binding.source.text = article.link
        binding.publishDate.text = TimeDiffUtil.getLastUpdateTime(
            article.pubDate!!,
            Constant.newsLastUpdatedDateTimeZoneFormat
        )

        if (!TextUtils.isEmpty(article.link)) {
            binding.sourceFavicon.loadAny(Constant.getFaviconFromSiteURL + article.link)
            if (article.link!!.contains("youtube")) {
                binding.articleImage.visibility = View.GONE
                binding.customWebView.visibility = View.VISIBLE
                WebViewUtil.webViewUrl = article.link!!
                WebViewUtil.setUpWebView(binding.customWebView, null)
                val videoId = article.link!!.split("v=")[1]
                WebViewUtil.loadDataWebView(
                    WebViewUtil.getStringForEmbedWebView(videoId),
                    binding.customWebView
                )
            } else {
                binding.articleImage.visibility = View.VISIBLE
                binding.customWebView.visibility = View.GONE
                if (!TextUtils.isEmpty(article.image)) {
                    binding.articleImage.load(article.image)
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

}