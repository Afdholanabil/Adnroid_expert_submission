package com.example.submission_awal_android_expert.data.retrofit

import com.example.submission_awal_android_expert.data.response.GameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGame(
        @Query("key") apiKey : String
    ):GameResponse
}