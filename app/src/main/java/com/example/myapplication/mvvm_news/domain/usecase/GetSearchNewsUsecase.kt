package com.example.myapplication.mvvm_news.domain.usecase

import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.util.Resource
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository

class GetSearchNewsUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery:String):Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }
}