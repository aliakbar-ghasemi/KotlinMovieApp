package com.aghasemi.kotlinmovieapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRepository
import com.aghasemi.kotlinmovieapp.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieRepository : MovieRepository) : ViewModel() {

    fun getMovieList(): LiveData<Resource<List<Movie>>> {
        return movieRepository.getMovieList()
    }
}