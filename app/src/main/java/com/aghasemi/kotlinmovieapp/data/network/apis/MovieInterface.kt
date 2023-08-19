package com.aghasemi.kotlinmovieapp.data.network.apis

import androidx.lifecycle.LiveData
import com.aghasemi.kotlinmovieapp.data.network.base.ApiResponse
import com.aghasemi.kotlinmovieapp.model.MovieListResponse
import retrofit2.http.GET

interface MovieInterface {
    @GET("?apikey=3e974fca&s=batman")
    fun getMovieList() : LiveData<ApiResponse<MovieListResponse>>
}