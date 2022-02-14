package com.reeta.newsproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.newsproject.R
import com.reeta.newsproject.apiResponse.Article
import com.reeta.newsproject.repository.Repository
import com.reeta.newsproject.viewModel.NewsFactory
import com.reeta.newsproject.viewModel.NewsViewModel
import com.reeta.triveouscryptocurrencyassignment.apiResponse.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var newsList = mutableListOf<Article>()
    lateinit var newsAdapter: NewsAdapter
    lateinit var repository: Repository
    lateinit var newsFactory: NewsFactory
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository = Repository()
        viewModel = ViewModelProviders.of(this, NewsFactory(repository))
            .get(NewsViewModel::class.java)

        setData()
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                filterNews(s.toString())
            }
        })
    }

    // This use for desired search result
    private fun filterNews(title: String) {
        val filterList = ArrayList<Article>()
        for (data in newsList) {
            if (data.title.toLowerCase().contains(title.toLowerCase())) {
                filterList.add(data)
            }
        }
        if (filterList.isEmpty()) {

        } else {
            newsAdapter.filterList(filterList)
        }
    }


    private fun setData() {
        progressBar.visibility = View.VISIBLE
        viewModel.getDataFromAPI().observe(this, {
            when (it.status) {
                Resource.Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.SUCCESS -> {
                    it.data?.articles.let {
                        if (it != null) {
                            newsList.addAll(it)
                            progressBar.visibility = View.GONE
                            setRecyclerView()
                        }
                    }
                }
            }
        })
    }

    private fun setRecyclerView() {
        newsAdapter= NewsAdapter(newsList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            adapter = newsAdapter
            layoutManager = linearLayoutManager
        }
    }

}