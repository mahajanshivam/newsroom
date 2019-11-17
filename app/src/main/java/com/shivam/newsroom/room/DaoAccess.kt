package com.shivam.newsroom.room

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.shivam.newsroom.model.NewsArticle


interface DaoAccess {

    @Insert
    fun insertArticle(note: NewsArticle)


    @Query("SELECT * FROM NewsArticle ORDER BY id")
    fun fetchAllTasks(): LiveData<List<NewsArticle>>


    @Query("SELECT * FROM NewsArticle WHERE id =:taskId")
    fun getTask(taskId: Int): LiveData<Note>
}