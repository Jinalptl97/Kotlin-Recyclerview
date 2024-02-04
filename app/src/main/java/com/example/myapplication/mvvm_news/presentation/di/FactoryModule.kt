package com.example.myapplication.mvvm_news.presentation.di

import android.app.Application
import com.example.myapplication.mvvm_news.domain.usecase.GetNewsHeadlinesUsecase
import com.example.myapplication.mvvm_news.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsVidewModelFactory(application: Application,getNewsHeadlinesUsecase: GetNewsHeadlinesUsecase):NewsViewModelFactory{
        return NewsViewModelFactory(application,getNewsHeadlinesUsecase)
    }
}