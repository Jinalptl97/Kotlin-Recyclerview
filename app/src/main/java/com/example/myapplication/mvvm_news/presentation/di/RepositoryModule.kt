package com.example.myapplication.mvvm_news.presentation.di

import com.example.myapplication.mvvm_news.data.repository.NewsRepositoryImpl
import com.example.myapplication.mvvm_news.data.repository.datasource.NewRemoteDataSource
import com.example.myapplication.mvvm_news.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newRemoteDataSource: NewRemoteDataSource):NewsRepository{
        return NewsRepositoryImpl(newRemoteDataSource)

    }
}