package com.aghasemi.kotlinmovieapp.di.module

import com.aghasemi.kotlinmovieapp.App
import com.aghasemi.kotlinmovieapp.data.local.db.AppDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDb(app: App): AppDatabase {
        return AppDatabase.getInstance(app)
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }
}