package com.aghasemi.kotlinmovieapp.data.network.base

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

open class OnlineResource<RequestType>(
    private val apiResponse: LiveData<ApiResponse<RequestType>>
) {
    private val result = MediatorLiveData<Resource<RequestType>>()

    init {
        result.value = Loading(null)
        fetchFromNetwork()
    }

    private fun fetchFromNetwork() {
        result.addSource(apiResponse) { response: ApiResponse<RequestType> ->
            result.removeSource(apiResponse)

            when (response) {
                is ApiEmptyResponse -> {
                    setValue(Success(null))
                }

                is ApiErrorResponse -> {
                    setValue(Failure(response.errorMsg, null))
                }

                is ApiSuccessResponse -> {
                    setValue(Success(response.body))
                }
            }
        }
    }

    @MainThread
    private fun setValue(newValue: Resource<RequestType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    fun asLiveData() = result as LiveData<Resource<RequestType>>
}