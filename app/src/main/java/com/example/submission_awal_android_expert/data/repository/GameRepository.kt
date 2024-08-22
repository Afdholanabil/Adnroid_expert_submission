package com.example.submission_awal_android_expert.data.repository

import com.example.submission_awal_android_expert.data.response.GameResponse
import com.example.submission_awal_android_expert.data.retrofit.ApiService

class GameRepository(private val apiService: ApiService?) {

    suspend fun getGame(key:String):GameResponse {
        return apiService!!.getGame(key)
    }

    companion object {
        @Volatile
        private var instance: GameRepository? = null

        fun getInstance(
            apiService: ApiService
        ) :GameRepository = instance ?: synchronized(this) {
            instance ?:GameRepository(apiService)
        }
    }
}