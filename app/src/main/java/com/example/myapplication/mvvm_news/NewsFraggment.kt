package com.example.myapplication.mvvm_news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.myapplication.mvvm_news.data.util.Resource
import com.example.myapplication.mvvm_news.databinding.FragmentNewsFraggmentBinding
import com.example.myapplication.mvvm_news.presentation.adapter.NewsAdapter
import com.example.myapplication.mvvm_news.presentation.viewmodel.NewsViewmodel

class NewsFraggment : Fragment() {

    lateinit var viewmodel: NewsViewmodel
    protected lateinit var binding: FragmentNewsFraggmentBinding
    private lateinit var newsAdapter: NewsAdapter
    private  var country="us"
    private  var page=1



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_fraggment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = (activity as MainActivity).viewmodel
        initRecycleview()
        viewNewsList()
    }

    private fun viewNewsList() {
        viewmodel.getNewsHeadLines(country,page)
        viewmodel.newsheadlines.observe(viewLifecycleOwner,{response->
            when(response){
            is Resource.Success->{
                hideProgressBar()
                response.data?.let {
                    newsAdapter.differ.submitList(it.articles.toList())
                }

            }
                is Resource.Error->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"An error occured : $it",Toast.LENGTH_LONG).show()
                    }

                }
                is Resource.Loading->{
                    showProgressBar()

                }
            }

        })
    }

    private fun initRecycleview() {
        newsAdapter=NewsAdapter()
        binding.rvItem.apply {
            adapter=newsAdapter
            layoutManager=LinearLayoutManager(activity)
        }

    }

    private fun showProgressBar(){
        binding.progressbar.visibility=View.VISIBLE
    }
    private fun hideProgressBar(){
        binding.progressbar.visibility=View.INVISIBLE
    }

}