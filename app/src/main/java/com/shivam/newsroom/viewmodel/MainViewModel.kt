package com.shivam.newsroom.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shivam.newsroom.model.NewsResponse
import com.shivam.newsroom.repository.NewsRepository

class MainViewModel : ViewModel() {

    private var newsResponseMutableLiveData: LiveData<NewsResponse?>? = null
    private var newsRepository: NewsRepository? = null


    fun init() {

        Log.d("newslog", "inside view model init method()")

        newsRepository = NewsRepository.getInstance()

    }

    fun getNewsRepository(
        key: String,
        pageSize: Int,
        page: Int
    ): LiveData<NewsResponse?>? {


        newsResponseMutableLiveData = newsRepository?.getNews("google-news", key, pageSize, page)

        return newsResponseMutableLiveData
    }


}