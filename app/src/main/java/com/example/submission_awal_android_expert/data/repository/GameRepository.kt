package com.example.submission_awal_android_expert.data.repository

import com.example.submission_awal_android_expert.data.response.GameResponse
import com.example.submission_awal_android_expert.data.response.ResultsItem
import com.example.submission_awal_android_expert.data.retrofit.ApiService
import com.example.submission_awal_android_expert.domain.model.Game

class GameRepository(private val apiService: ApiService?) {

    suspend fun getGame(key:String):GameResponse {
        return apiService!!.getGame(key)
    }

    fun ResultsItem.toGame(): Game {
        return Game(
            id = this.id ?: 0,
            name = this.name ?: "Unknown",
            imageUrl = this.backgroundImage ?: "",
            rating = this.rating.toString().toDouble() ?: 0.0
        )
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