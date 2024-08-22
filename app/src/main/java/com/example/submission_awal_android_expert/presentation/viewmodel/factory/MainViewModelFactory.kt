package com.example.submission_awal_android_expert.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission_awal_android_expert.data.repository.GameRepository
import com.example.submission_awal_android_expert.presentation.viewmodel.MainViewModel

class MainViewModelFactory(private val gameRepository: GameRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(gameRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class : ${modelClass.name}")
    }
}