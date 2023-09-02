package com.aghasemi.kotlinmovieapp.data.repository

import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.network.base.ApiClient
import com.aghasemi.kotlinmovieapp.data.network.base.ApiResponse
import com.aghasemi.kotlinmovieapp.data.network.base.OnlineResource
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.model.MovieListResponse
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor() {
    private var movieInterface = ApiClient.getMovieInterface()

    fun getMovieList(): LiveData<Resource<MovieListResponse>> {
        return OnlineResource(movieInterface.getMovieList()).asLiveData()
    }

    fun getMovies(): LiveData<ApiResponse<MovieListResponse>> {
        return movieInterface.getMovieList()
    }
}