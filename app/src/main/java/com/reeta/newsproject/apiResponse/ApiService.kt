package com.reeta.newsproject.apiResponse

import retrofit2.http.GET
import retrofit2.http.Query

/*
this is ApiService interface, it will help for Api calling, I am passing the country, category
and apikey as a query parameter.
 */
interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): ResponseDTO
}