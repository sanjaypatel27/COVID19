package com.diyainfotech.covid19.ui.news

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.diyainfotech.covid19.R
import com.diyainfotech.covid19.rssFeedParser.Article

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById(R.id.title) as TextView
    private val description = itemView.findViewById(R.id.description) as TextView
    private val articleImage = itemView.findViewById(R.id.articleImage) as ImageView

    fun bindData(article: Article) {
        Log.d("Sanjay","Article : $adapterPosition : \n $article " )
        title.text = article.title
        description.text = article.description
        if (article.image != null) {
            articleImage.load(article.image) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

    }
}