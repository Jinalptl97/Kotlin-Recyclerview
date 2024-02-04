package com.example.myapplication.mvvm_news.domain.usecase

import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository

class DeleteSavedUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.deleteNews(article)
}