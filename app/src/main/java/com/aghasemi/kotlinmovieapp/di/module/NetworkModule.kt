package com.aghasemi.kotlinmovieapp.di.module

import android.app.Application
import com.aghasemi.kotlinmovieapp.App
import com.aghasemi.kotlinmovieapp.data.network.apis.MovieInterface
import com.aghasemi.kotlinmovieapp.data.network.base.adapter.LiveDataCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttpCache(get()) }
    factory { provideOKHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideMovieInterface(get()) }
}

private const val BASE_URL = "https://www.omdbapi.com/"
private const val OKHTTP_CACHE_SIZE = 10 * 1024 * 1024L
fun provideOkHttpCache(app: Application): Cache {
    return Cache(app.cacheDir, OKHTTP_CACHE_SIZE)
}

fun provideOKHttpClient(cache: Cache): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(24, TimeUnit.SECONDS)
        .cache(cache)

    return httpClient.build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

/**
 *  API Services
 */
fun provideMovieInterface(retrofit: Retrofit): MovieInterface {
    return retrofit.create(MovieInterface::class.java)
}
