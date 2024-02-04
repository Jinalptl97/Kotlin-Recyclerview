package com.example.myapplication.mvvm_news.presentation.di

import com.example.myapplication.mvvm_news.BuildConfig
import com.example.myapplication.mvvm_news.data.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    @Singleton
    fun ProvideRetrofit():Retrofit{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    fun ProvideNewApiService(retrofit: Retrofit):NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }
}