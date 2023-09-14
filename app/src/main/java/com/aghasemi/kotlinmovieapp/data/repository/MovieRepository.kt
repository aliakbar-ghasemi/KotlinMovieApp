package com.aghasemi.kotlinmovieapp.data.repository

import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.network.base.ApiResponse
import com.aghasemi.kotlinmovieapp.data.network.base.AppExecutors
import com.aghasemi.kotlinmovieapp.data.network.base.NetworkBoundResource
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.model.Movie
import com.aghasemi.kotlinmovieapp.model.MovieListResponse

class MovieRepository(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) {

    fun getMovieList(): LiveData<Resource<List<Movie>>> =
        object :
            NetworkBoundResource<List<Movie>, MovieListResponse>(AppExecutors.instance!!) {
            override fun saveCallResult(item: MovieListResponse) {
                movieLocalDataSource.insertAll(item.search)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data.isNullOrEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieLocalDataSource.getMovieList()
            }

            override fun createCall(): LiveData<ApiResponse<MovieListResponse>> {
                return movieRemoteDataSource.getMovies()
            }
        }.asLiveData()
}