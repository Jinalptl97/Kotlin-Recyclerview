package com.example.myapplication.mvvm_news.presentation.di

import com.example.myapplication.mvvm_news.data.api.NewsApiService
import com.example.myapplication.mvvm_news.data.repository.datasource.NewRemoteDataSource
import com.example.myapplication.mvvm_news.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsApiService: NewsApiService): NewRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}