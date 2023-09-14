package com.aghasemi.kotlinmovieapp.data.repository

import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.local.db.dao.MovieDao
import com.aghasemi.kotlinmovieapp.model.Movie

class MovieLocalDataSource(private val movieDao: MovieDao) {

    fun getMovieList(): LiveData<List<Movie>> {
        return movieDao.getAll()
    }

    fun insertAll(movies: ArrayList<Movie>) {
        movieDao.insertAll(movies)
    }
}