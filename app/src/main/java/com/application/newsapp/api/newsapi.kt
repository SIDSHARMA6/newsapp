package com.application.newsapp.api


import com.application.newsapp.model.NewsResponse
import com.application.newsapp.util.Constant.Companion.APIKEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsapi {
    @GET("v2/top-headlines")
    suspend fun getheadlines(
@Query("country")
countryCode: String="In",
@Query("page")
pageNumber: Int=1,
@Query("Apikey")
apikey:String=APIKEY

    ):Response<NewsResponse>
    @GET("v2/everything")
    suspend fun searchfornews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int=1,

        @Query("apikey")
        apikey:String= APIKEY
    ):Response<NewsResponse>
}