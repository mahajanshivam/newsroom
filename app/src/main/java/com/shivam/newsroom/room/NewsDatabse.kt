package com.shivam.newsroom.room

import androidx.room.RoomDatabase
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import com.shivam.newsroom.model.NewsArticle


@Database(entities = [NewsArticle::class], version = 1, exportSchema = false)
abstract class NewsDatabse : RoomDatabase() {

    abstract fun daoAccess(): DaoAccess
}