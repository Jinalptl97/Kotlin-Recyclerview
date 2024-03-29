package com.example.myapplication.mvvm_news.data.model


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)