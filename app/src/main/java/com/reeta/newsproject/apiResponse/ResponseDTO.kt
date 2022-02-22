package com.reeta.newsproject.apiResponse

data class ResponseDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)