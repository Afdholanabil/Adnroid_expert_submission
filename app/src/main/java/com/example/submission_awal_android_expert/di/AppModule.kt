package com.example.submission_awal_android_expert.di

import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.submission_awal_android_expert.data.local.AppDatabase
import com.example.submission_awal_android_expert.presentation.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single { databaseBuilder(get(), AppDatabase::class.java, "game_db").build() }
    single { get<AppDatabase>().favoriteGameDao() }
    viewModel { GameViewModel(get()) }
}