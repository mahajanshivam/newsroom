package com.shivam.newsroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "articles"
)
data class NewsArticle(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @SerializedName("source") var source: NewsSource? = null,

    @ColumnInfo(name = "author")
    @SerializedName("author") var author: String? = null,

    @ColumnInfo(name = "title")
    @SerializedName("title") var title: String? = null,

    @ColumnInfo(name = "description")
    @SerializedName("description") var description: String? = null,

    @ColumnInfo(name = "url")
    @SerializedName("url") var url: String? = null,

    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage") var urlToImage: String? = null,

    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt") var publishedAt: String? = null,

    @ColumnInfo(name = "content")
    @SerializedName("content") var content: String? = null

):Serializable
