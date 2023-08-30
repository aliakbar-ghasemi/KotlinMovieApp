package com.aghasemi.kotlinmovieapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.local.db.AppDatabase
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import com.aghasemi.kotlinmovieapp.model.Movie
import java.util.ArrayList

class MovieLocalDataSource(application: Application) {
    private val movieDao: MovieDao

    init {
        val db = AppDatabase.getInstance(application)
        movieDao = db.movieDao()
    }

    fun getMovieList(): LiveData<List<Movie>> {
        return movieDao.getAll()
    }

    fun insertAll(movies: ArrayList<Movie>) {
        movieDao.insertAll(movies)
    }
}