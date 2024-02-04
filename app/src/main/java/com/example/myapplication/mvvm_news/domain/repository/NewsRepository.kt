package com.example.myapplication.mvvm_news.domain.repository


import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int):Resource<APIResponse>
    suspend fun getSearchedNews(SearchQuery:String):Resource<APIResponse>
    suspend fun savedNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}