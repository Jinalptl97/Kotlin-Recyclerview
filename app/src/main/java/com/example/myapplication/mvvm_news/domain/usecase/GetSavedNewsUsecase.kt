package com.example.myapplication.mvvm_news.domain.usecase

import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUsecase(private  val newsRepository: NewsRepository) {
    fun  execute():Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}