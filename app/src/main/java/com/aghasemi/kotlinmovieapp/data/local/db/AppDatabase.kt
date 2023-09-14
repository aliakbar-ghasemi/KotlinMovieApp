package com.aghasemi.kotlinmovieapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import com.aghasemi.kotlinmovieapp.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}