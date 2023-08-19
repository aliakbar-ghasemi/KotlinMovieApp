package com.aghasemi.kotlinmovieapp.data.network.apis

import retrofit2.http.GET

interface MovieInterface {
    @GET("?apikey=3e974fca&s=batman")
    fun getMovieList()
}