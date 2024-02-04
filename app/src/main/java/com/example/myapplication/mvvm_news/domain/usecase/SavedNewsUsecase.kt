package com.example.myapplication.mvvm_news.domain.usecase

import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository

class SavedNewsUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.savedNews(article)
}