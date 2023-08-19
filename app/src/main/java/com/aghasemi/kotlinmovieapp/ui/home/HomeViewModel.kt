package com.aghasemi.kotlinmovieapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRepository
import com.aghasemi.kotlinmovieapp.model.MovieListResponse

class HomeViewModel : ViewModel() {
    private var movieRepository = MovieRepository()

    fun getMovieList(): LiveData<Resource<MovieListResponse>> {
        return movieRepository.getMovieList()
    }
}