package com.shivam.newsroom.room

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shivam.newsroom.model.NewsArticle


interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(articles: List<NewsArticle>)


    @Query("SELECT * FROM articles ORDER BY id")
    fun fetchAllArticles(): LiveData<List<NewsArticle>>


    @Query("SELECT * FROM articles WHERE id =:id")
    fun getArticle(id: Int): LiveData<Note>
}