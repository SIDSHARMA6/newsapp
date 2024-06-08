package com.application.newsapp.repository

import com.application.newsapp.api.RetroFitInstance
import com.application.newsapp.db.ArticleDatabase
import com.application.newsapp.model.Article
import retrofit2.Response

class NewsRepository( val db:ArticleDatabase) {
    suspend fun getHeadlines(countryCode:String,pageNumber: Int)=
        RetroFitInstance.api.getheadlines(countryCode , pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int)=
        RetroFitInstance.api.searchfornews(searchQuery , pageNumber)

    suspend fun upsert(article:Article)=db.getArticleDao().upsert(article)
fun getFavouriteNews()=db.getArticleDao().getallArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)



}