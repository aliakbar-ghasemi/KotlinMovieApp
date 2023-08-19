package com.aghasemi.kotlinmovieapp.data.repository

import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.model.MovieListResponse

class MovieRepository {
    private var movieRemoteDataSource = MovieRemoteDataSource()
    fun getMovieList(): LiveData<Resource<MovieListResponse>> {
        return movieRemoteDataSource.getMovieList()
    }
}