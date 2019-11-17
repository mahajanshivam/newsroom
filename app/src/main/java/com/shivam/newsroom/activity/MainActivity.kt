package com.shivam.newsroom.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivam.newsroom.R
import com.shivam.newsroom.adapter.NewsDataAdapter
import com.shivam.newsroom.model.NewsArticle
import com.shivam.newsroom.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var articleArrayList: ArrayList<NewsArticle> = ArrayList()
    private var newsAdapter: NewsDataAdapter? = null
    private lateinit var newsViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        newsViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
        newsViewModel.init()
        newsViewModel.getNewsRepository(resources.getString(R.string.news_api_key))
            ?.observe(this, Observer {

                if (progBar.visibility == View.VISIBLE) {
                    progBar.visibility = View.GONE
                    rvNews.visibility = View.VISIBLE
                }
                Log.d("newslog", "inside main activity observer = " + it?.articles?.size)

                var newsArticles: List<NewsArticle>? = it?.articles

                if (newsArticles != null) {
                    articleArrayList.addAll(newsArticles)
                    newsAdapter?.notifyDataSetChanged()
                }
            })

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = NewsDataAdapter(this@MainActivity, articleArrayList)
            rvNews.layoutManager = LinearLayoutManager(this)
            rvNews.adapter = newsAdapter
            rvNews.itemAnimator = DefaultItemAnimator()
            rvNews.isNestedScrollingEnabled = true
        } else {
            newsAdapter?.notifyDataSetChanged()
        }
    }
}
