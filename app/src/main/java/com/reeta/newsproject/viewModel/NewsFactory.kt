package com.reeta.newsproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reeta.newsproject.repository.Repository
import javax.inject.Inject

class NewsFactory@Inject constructor(private var repository: Repository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }

}