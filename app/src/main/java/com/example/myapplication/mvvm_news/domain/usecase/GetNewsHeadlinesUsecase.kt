package com.example.myapplication.mvvm_news.domain.usecase

import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.util.Resource
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository

class GetNewsHeadlinesUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(country:String,page:Int):Resource<APIResponse>{
        return newsRepository.getNewsHeadlines(country,page)
    }
}