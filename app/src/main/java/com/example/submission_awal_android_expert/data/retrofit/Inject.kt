package com.example.submission_awal_android_expert.data.retrofit

import android.content.Context
import com.example.submission_awal_android_expert.data.repository.GameRepository
import com.example.submission_awal_android_expert.help.gameAdapter

object Inject {

    fun gameRepository(context: Context) : GameRepository {
        val apiService = ApiConfig.getApiService()
        return GameRepository.getInstance(apiService!!)
    }
}