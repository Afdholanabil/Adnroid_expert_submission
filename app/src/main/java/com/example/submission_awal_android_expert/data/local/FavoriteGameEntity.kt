package com.example.submission_awal_android_expert.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_games")
data class FavoriteGame(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val ratings: Double,
)