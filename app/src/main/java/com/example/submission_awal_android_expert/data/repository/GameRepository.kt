package com.example.submission_awal_android_expert.data.repository

import com.example.submission_awal_android_expert.data.response.GameResponse
import com.example.submission_awal_android_expert.data.retrofit.ApiService

class GameRepository(private val apiService: ApiService) {

    suspend fun getGame(key:String):GameResponse {
        return apiService.getGame(key)
    }
}