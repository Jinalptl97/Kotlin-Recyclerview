package com.example.myapplication.mvvm_news.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.mvvm_news.data.model.APIResponse
import com.example.myapplication.mvvm_news.data.util.Resource
import com.example.myapplication.mvvm_news.domain.usecase.GetNewsHeadlinesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewmodel(
   private val app:Application,
   private val getNewsHeadlinesUsecase: GetNewsHeadlinesUsecase) : ViewModel() {
    val newsheadlines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()


    fun getNewsHeadLines(country:String, page:Int)=viewModelScope.launch (Dispatchers.IO){
        newsheadlines.postValue(Resource.Loading())
        try {
            if(isNetworkAvailable(app)) {
                newsheadlines.postValue(Resource.Loading())
                val apiresult = getNewsHeadlinesUsecase.execute(country, page)
                newsheadlines.postValue(apiresult)
            }
            else{
                newsheadlines.postValue(Resource.Error("Internet is not available"))
            }
        }
        catch (e:Exception){
            newsheadlines.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return  false
    }
}