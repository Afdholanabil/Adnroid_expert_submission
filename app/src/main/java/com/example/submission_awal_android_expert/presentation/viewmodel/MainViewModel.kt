package com.example.submission_awal_android_expert.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission_awal_android_expert.data.repository.GameRepository
import com.example.submission_awal_android_expert.data.response.GameResponse
import kotlinx.coroutines.launch

class MainViewModel(private val gameRepository: GameRepository) :ViewModel() {
    private val _allGame =MutableLiveData<Result<GameResponse>>()
    val allGame : LiveData<Result<GameResponse>> = _allGame

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading


    fun getAllGame(key:String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response =gameRepository.getGame(key)
                _allGame.postValue(Result.success(response))
                _loading.value = false
            }catch (e: Exception) {
                _allGame.postValue(Result.failure(e))
                _loading.value = false
            }
        }
    }
}