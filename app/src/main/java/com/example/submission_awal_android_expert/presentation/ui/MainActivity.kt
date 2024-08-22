package com.example.submission_awal_android_expert.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.submission_awal_android_expert.BuildConfig
import com.example.submission_awal_android_expert.data.repository.GameRepository
import com.example.submission_awal_android_expert.data.response.ResultsItem
import com.example.submission_awal_android_expert.data.retrofit.ApiConfig
import com.example.submission_awal_android_expert.databinding.ActivityMainBinding
import com.example.submission_awal_android_expert.help.gameAdapter
import com.example.submission_awal_android_expert.presentation.viewmodel.MainViewModel
import com.example.submission_awal_android_expert.presentation.viewmodel.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var gameRepository: GameRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService =ApiConfig.getApiService()
        gameRepository = GameRepository(apiService)

        val mainViewModelF = MainViewModelFactory(gameRepository)
        viewModel = ViewModelProvider(this, mainViewModelF).get(MainViewModel::class.java)

        setupRecycler()

        viewModel.allGame.observe(this) {
            it.onSuccess {
                it.results.let { data ->
                    if(data!= null) {
                        listData(data)
                    }
                }
            }
        }
        viewModel.getAllGame(KEY)
        viewModel.loading.observe(this) {
            setLoading(it)
        }
    }

    private fun setupRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvJudulGame.layoutManager =linearLayoutManager
        val itemDecoration =DividerItemDecoration(this, linearLayoutManager.orientation)
        binding.rvJudulGame.addItemDecoration(itemDecoration)

        val adapter = gameAdapter(emptyList(),this)
        binding.rvJudulGame.adapter = adapter
    }

    private fun listData(data: List<ResultsItem?>?) {
        val adapter = gameAdapter(data, this)
        binding.rvJudulGame.adapter = adapter
    }

    private fun setLoading(isLoading : Boolean) {
        if (isLoading) {
            binding.progresBar.visibility = View.VISIBLE
        }else {
            binding.progresBar.visibility = View.GONE
        }
    }

    companion object {
        private const val KEY = BuildConfig.API_KEY
    }
}