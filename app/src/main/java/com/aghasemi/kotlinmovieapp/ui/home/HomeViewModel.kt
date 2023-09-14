package com.aghasemi.kotlinmovieapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRepository
import com.aghasemi.kotlinmovieapp.model.Movie

class HomeViewModel(private val movieRepository : MovieRepository) : ViewModel() {

    fun getMovieList(): LiveData<Resource<List<Movie>>> {
        return movieRepository.getMovieList()
    }
}