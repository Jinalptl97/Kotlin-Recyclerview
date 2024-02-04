package com.example.myapplication.mvvm_news.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.myapplication.mvvm_news.data.model.Article
import com.example.myapplication.mvvm_news.databinding.NewsListItemBinding

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback=object:DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,callback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding=NewsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val article=differ.currentList[position]
        holder.bind(article)
    }



    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class NewsViewHolder(val binding: NewsListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            binding.tvTitle.text=article.title
            binding.tvDescription.text=article.author
            binding.tvPublishedAt.text=article.publishedAt
            binding.tvSource.text=article.source.name
            Glide.with(binding.ivArticleImage.context).load(article.url).into(binding.ivArticleImage)
        }
    }



}
