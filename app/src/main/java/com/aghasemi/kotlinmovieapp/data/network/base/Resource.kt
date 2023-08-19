package com.aghasemi.kotlinmovieapp.data.network.base

sealed class Resource<out T>{

}
class Success<T>(val data: T?): Resource<T>()
class Failure<T>(val message: String, val data: T?): Resource<T>()
class Loading<T>(val data: T?): Resource<T>()