package com.example.headline.api

import com.example.headline.model.Article
import com.example.headline.model.New
import com.example.headline.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadApiInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<New>
}