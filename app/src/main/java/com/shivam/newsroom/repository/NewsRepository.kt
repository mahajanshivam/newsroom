package com.shivam.newsroom.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shivam.newsroom.api.NewsApi
import com.shivam.newsroom.model.NewsResponse
import com.shivam.newsroom.service.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import androidx.room.Room
import com.shivam.newsroom.room.NewsDatabse


class NewsRepository {

    private var newsApi: NewsApi? = null
    private val DB_NAME = "db_news"
    private lateinit var newsDatabase: NewsDatabse

    init {
        Log.d("newslog", "inside NewsRepository init method()")

        newsApi = RetrofitService.createService(NewsApi::class.java)
//        newsDatabase = Room.databaseBuilder( NewsDatabse::class.java!!, DB_NAME).build()

    }

    companion object {

        private var newsRepository: NewsRepository? = null

        fun getInstance(): NewsRepository? {

            Log.d("newslog", "inside NewsRepository getInstance()")

            if (newsRepository == null) {
                newsRepository = NewsRepository()
            }

            return newsRepository
        }
    }


    fun getNews(
        source: String,
        key: String,
        pageSize: Int,
        page: Int
    ): MutableLiveData<NewsResponse> {

        val newsLiveData: MutableLiveData<NewsResponse> = MutableLiveData()


        newsApi?.getNewsList(source, key, pageSize, page)?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeWith(object : DisposableSingleObserver<NewsResponse>() {
                override fun onSuccess(news: NewsResponse) {
                    Log.d("newslog", "response = " + news.toString())
                    newsLiveData.value = news
                }

                override fun onError(e: Throwable) {
                    Log.d("newslog", "excepotion in response = " + e.message)
                    newsLiveData.value = null
                }
            })


        return newsLiveData
    }

}