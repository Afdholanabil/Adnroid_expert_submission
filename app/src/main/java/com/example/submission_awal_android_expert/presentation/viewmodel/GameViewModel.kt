package com.example.submission_awal_android_expert.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.submission_awal_android_expert.data.local.FavoriteGame
import com.example.submission_awal_android_expert.data.local.FavoriteGameDao
import com.example.submission_awal_android_expert.data.response.ResultsItem
import com.example.submission_awal_android_expert.domain.model.Game
import kotlinx.coroutines.launch

class GameViewModel(private val favoriteGameDao: FavoriteGameDao) : ViewModel() {

    val favoriteGames: LiveData<List<FavoriteGame>> = favoriteGameDao.getAllFavoriteGames().asLiveData()



    fun addFavorite(game: Game) {
        viewModelScope.launch {
            val favoriteGame = FavoriteGame(game.id, game.name, game.imageUrl, game.rating)
            favoriteGameDao.insertFavoriteGame(favoriteGame)
        }
    }

    fun removeFavorite(game: Game) {
        viewModelScope.launch {
            val favoriteGame = FavoriteGame(game.id, game.name, game.imageUrl, game.rating)
            favoriteGameDao.deleteFavoriteGame(favoriteGame)
        }
    }
}
