package com.reeta.newsproject.repository

import com.reeta.newsproject.apiResponse.ResponseDTO
import com.reeta.newsproject.di.Constants
import com.reeta.newsproject.di.Module
import com.reeta.triveouscryptocurrencyassignment.apiResponse.Resource
import com.reeta.triveouscryptocurrencyassignment.apiResponse.ResponseHandler

/*
This is repository , it will be a intermediator between viewModel and our data source.
 */
class Repository {

    private val responseHandler: ResponseHandler = ResponseHandler()

    suspend fun getDataFromAPI(): Resource<ResponseDTO> {
        return try {
            val responseDTO: ResponseDTO =
                Module.provideApiService()
                    .getNews(Constants.country, Constants.category, Constants.api_key)
            responseHandler.handleSuccess(responseDTO)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}