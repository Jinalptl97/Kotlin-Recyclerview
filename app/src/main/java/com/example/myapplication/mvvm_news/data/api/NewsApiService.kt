package com.example.myapplication.mvvm_news.data.api

import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.google.gson.internal.GsonBuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apikey:String="d260fed101a745b3a186165f6a3db1af"
    ): Response<APIResponse>
}