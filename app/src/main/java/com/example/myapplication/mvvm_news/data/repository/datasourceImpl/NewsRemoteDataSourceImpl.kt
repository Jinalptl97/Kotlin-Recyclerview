package com.example.myapplication.mvvm_news.data.repository.datasourceImpl

import com.example.myapplication.mvvm_news.data.api.NewsApiService
import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.repository.datasource.NewRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,

):NewRemoteDataSource {
    override suspend fun gettopHeadlines(country:String,page:Int): Response<APIResponse> {
       return  newsApiService.getTopHeadlines(country,page)
    }

}