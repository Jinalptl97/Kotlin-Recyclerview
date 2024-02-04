package com.example.myapplication.mvvm_news.presentation.di

import com.example.myapplication.mvvm_news.data.repository.NewsRepositoryImpl
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository
import com.example.myapplication.mvvm_news.domain.usecase.GetNewsHeadlinesUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providedGetNewsHeadLinesUsecase(
        newsRepository: NewsRepository
    ):GetNewsHeadlinesUsecase{
        return GetNewsHeadlinesUsecase(newsRepository)

    }
}