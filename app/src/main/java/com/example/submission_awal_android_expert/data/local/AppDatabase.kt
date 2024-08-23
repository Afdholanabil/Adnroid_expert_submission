package com.example.submission_awal_android_expert.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteGame::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteGameDao(): FavoriteGameDao
}
