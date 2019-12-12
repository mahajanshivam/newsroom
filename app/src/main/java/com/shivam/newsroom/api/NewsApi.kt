package com.shivam.newsroom.api

import com.shivam.newsroom.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getNewsList(
        @Query("sources") newsSource: String, @Query("apiKey") apiKey: String
        , @Query("pageSize") pageSize: Int, @Query("page") page: Int
    ): Single<NewsResponse>
}