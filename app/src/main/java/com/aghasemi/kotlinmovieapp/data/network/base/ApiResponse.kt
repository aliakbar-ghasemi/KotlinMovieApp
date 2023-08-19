package com.aghasemi.kotlinmovieapp.data.network.base

import retrofit2.Response

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "unknown error")
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                return if (body == null || response.code() == 204) { // 204 is empty response code
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(body)
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                ApiErrorResponse(errorMsg)
            }
        }
    }
}
class ApiEmptyResponse<T> : ApiResponse<T>()
class ApiSuccessResponse<T> internal constructor(val body: T) : ApiResponse<T>()
class ApiErrorResponse<T> internal constructor(val errorMsg: String) : ApiResponse<T>()
