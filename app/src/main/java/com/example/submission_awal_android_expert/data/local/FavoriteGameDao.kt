package com.example.submission_awal_android_expert.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGameDao {
    @Query("SELECT * FROM favorite_games")
    fun getAllFavoriteGames(): Flow<List<FavoriteGame>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteGame(game: FavoriteGame)

    @Delete
    suspend fun deleteFavoriteGame(game: FavoriteGame)
}
