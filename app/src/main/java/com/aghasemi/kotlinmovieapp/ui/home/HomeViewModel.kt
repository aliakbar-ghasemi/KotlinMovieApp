package com.aghasemi.kotlinmovieapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.network.base.Resource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRepository
import com.aghasemi.kotlinmovieapp.model.Movie

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private var movieRepository = MovieRepository(application)

    fun getMovieList(): LiveData<Resource<List<Movie>>> {
        return movieRepository.getMovieList()
    }
}