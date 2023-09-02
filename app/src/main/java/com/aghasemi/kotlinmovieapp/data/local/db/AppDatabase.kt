package com.aghasemi.kotlinmovieapp.data.local.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import com.aghasemi.kotlinmovieapp.model.Movie
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    class Callback @Inject constructor(private val database: Provider<AppDatabase>) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //insert db at the first time

            //val dao = database.get().movieDao()
            //dao.insert()
        }
    }
}