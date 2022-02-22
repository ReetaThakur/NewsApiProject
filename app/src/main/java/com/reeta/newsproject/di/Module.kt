package com.reeta.newsproject.di

import com.reeta.newsproject.apiResponse.ApiService
import com.reeta.newsproject.di.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
This is a Module class that will provides all dependecies we required.
 */
@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideApiService(): ApiService {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(ApiService::class.java)
    }

}

object Constants {
    const val BASE_URL = "https://newsapi.org"
    const val api_key = "dd5a27aa96e6435999947ed875aec407"
    const val country = "us"
    const val category = "business"
}