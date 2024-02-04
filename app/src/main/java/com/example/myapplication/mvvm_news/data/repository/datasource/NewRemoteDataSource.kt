package com.example.myapplication.mvvm_news.data.repository.datasource

import com.example.myapplication.mvvm_news.data.model.APIResponse
import retrofit2.Response

interface NewRemoteDataSource {
    suspend fun gettopHeadlines(country:String,page:Int):Response<APIResponse>
}