package com.reeta.newsproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reeta.newsproject.apiResponse.ResponseDTO
import com.reeta.newsproject.repository.Repository
import com.reeta.triveouscryptocurrencyassignment.apiResponse.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NewsViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    fun getDataFromAPI(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = repository.getDataFromAPI()
            emit(data)
        }
    }
}