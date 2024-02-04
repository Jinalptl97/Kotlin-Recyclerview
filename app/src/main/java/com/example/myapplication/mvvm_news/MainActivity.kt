package com.example.myapplication.mvvm_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.mvvm_news.databinding.ActivityMainBinding
import com.example.myapplication.mvvm_news.presentation.viewmodel.NewsViewModelFactory
import com.example.myapplication.mvvm_news.presentation.viewmodel.NewsViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
     lateinit var viewmodel: NewsViewmodel
     @Inject
     lateinit var factory: NewsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(navController)

        viewmodel= ViewModelProvider(this,factory).get(NewsViewmodel::class.java)


    }
}