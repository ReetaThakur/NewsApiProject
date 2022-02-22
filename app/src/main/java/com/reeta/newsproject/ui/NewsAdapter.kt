package com.reeta.newsproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reeta.newsproject.R
import com.reeta.newsproject.apiResponse.Article

class NewsAdapter(var newsList:List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val list=newsList[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    //this method for search item in search box
    fun filterList(filterList: ArrayList<Article>) {
        newsList = filterList
        notifyDataSetChanged()
    }

   inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val newsTiming:TextView=itemView.findViewById(R.id.tvNewsTiming)
        val newsSource:TextView=itemView.findViewById(R.id.tvNewsSource)
        val newsTitle:TextView=itemView.findViewById(R.id.tvNewsTitle)
        val newsDescription:TextView=itemView.findViewById(R.id.tvNewsDescription)
        val newsImage:ImageView=itemView.findViewById(R.id.newsImage)


        fun setData(article: Article){
            newsTiming.text=" \u2022 ${Utils.DateToTimeFormat(article.publishedAt)}"
            newsSource.text=article.source.name
            newsTitle.text=article.title
            newsDescription.text=article.description
            Glide.with(newsImage).load(article.urlToImage).into(newsImage)
        }
    }
}