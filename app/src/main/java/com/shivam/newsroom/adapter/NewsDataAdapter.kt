package com.shivam.newsroom.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivam.newsroom.R
import com.shivam.newsroom.activity.WebviewActivity
import com.shivam.newsroom.model.NewsArticle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDataAdapter(var context: Context, var articleList: ArrayList<NewsArticle>) :
    RecyclerView.Adapter<NewsDataAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.setData(position)
    }


    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setData(position: Int) {

            itemView.tvName.setText(articleList[position].title.toString())
            itemView.tvDesCription.setText(articleList[position].description.toString())
            Picasso.get().load(articleList[position].urlToImage).into(itemView.ivNews)

            itemView.itemRoot.setOnClickListener {
                val intent = Intent(context, WebviewActivity::class.java)
                intent.putExtra("url", articleList[position].url)
                context.startActivity(intent)
            }
        }
    }
}