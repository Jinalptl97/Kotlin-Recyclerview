package com.example.myapplication.mvvm_news.data.repository

import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.data.repository.datasource.NewRemoteDataSource
import com.example.myapplication.mvvm_news.data.util.Resource
import com.example.myapplication.mvvm_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newRemoteDataSource: NewRemoteDataSource
):NewsRepository {
    override suspend fun getNewsHeadlines(country:String,page:Int): Resource<APIResponse> {
        return responseToResource(newRemoteDataSource.gettopHeadlines(country,page))
    }

    private fun responseToResource(response: Response<APIResponse>) :Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
       return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(SearchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun savedNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}