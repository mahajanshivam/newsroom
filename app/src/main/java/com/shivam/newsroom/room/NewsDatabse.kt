package com.shivam.newsroom.room

import androidx.room.RoomDatabase
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NewsDatabse : RoomDatabase() {

    abstract fun daoAccess(): DaoAccess
}