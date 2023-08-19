package com.aghasemi.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("Search")
    val search: ArrayList<Movie>,
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("Response")
    val response: String
)