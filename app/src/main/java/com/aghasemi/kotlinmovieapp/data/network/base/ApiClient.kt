package com.aghasemi.kotlinmovieapp.data.network.base

import com.aghasemi.kotlinmovieapp.data.network.apis.MovieInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var BASE_URL = "https://www.omdbapi.com/"
    private var retrofit: Retrofit? = null
    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.addConverterFactory(ScalarsConverterFactory.create())
                //.addCallAdapterFactory(new LiveDataCallAdapterFactory())
                //.client(provideOkHttpClientInstance())
                .client(provideOkHttpClient())
                .build()
        }

        return retrofit!!
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
    }

    /**
     * Interfaces
     */
    fun getMovieInterface(): MovieInterface {
        return getRetrofit().create(MovieInterface::class.java)
    }
}