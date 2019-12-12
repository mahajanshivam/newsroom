package com.shivam.newsroom.dagger_module

import android.app.Application
import androidx.room.Room
import com.shivam.newsroom.room.DaoAccess
import com.shivam.newsroom.room.NewsDatabse
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): NewsDatabse = Room.databaseBuilder(
        app,
        NewsDatabse::class.java, "news_db"
    ).build()

    @Provides
    @Singleton
    fun provideNewsDao(database: NewsDatabse): DaoAccess =
        database.daoAccess()

}