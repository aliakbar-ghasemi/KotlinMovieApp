package com.aghasemi.kotlinmovieapp.di.module

import android.app.Application
import androidx.room.Room
import com.aghasemi.kotlinmovieapp.data.local.db.AppDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(app: Application, callback: AppDatabase.Callback): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "app.db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }
}