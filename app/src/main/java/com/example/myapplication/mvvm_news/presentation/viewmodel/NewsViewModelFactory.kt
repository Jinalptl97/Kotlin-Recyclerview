package com.example.myapplication.mvvm_news.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.mvvm_news.domain.usecase.GetNewsHeadlinesUsecase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUsecase: GetNewsHeadlinesUsecase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewmodel(
            app,
            getNewsHeadlinesUsecase
        ) as T
    }
}