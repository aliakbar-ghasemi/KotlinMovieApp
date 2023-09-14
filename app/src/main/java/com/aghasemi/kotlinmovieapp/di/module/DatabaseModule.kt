package com.aghasemi.kotlinmovieapp.di.module

import android.app.Application
import androidx.room.Room
import com.aghasemi.kotlinmovieapp.data.local.db.AppDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import org.koin.dsl.module

val databaseModule = module {
    single { provideDb(get()) }
    single { provideMovieDao(get()) }
}

fun provideDb(app: Application): AppDatabase {
    return Room.databaseBuilder(app, AppDatabase::class.java, "app.db")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideMovieDao(db: AppDatabase): MovieDao {
    return db.movieDao()
}