package com.aghasemi.kotlinmovieapp.di.module

import android.app.Application
import com.aghasemi.kotlinmovieapp.data.network.apis.MovieInterface
import com.aghasemi.kotlinmovieapp.data.network.base.adapter.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val baseURL = "https://www.omdbapi.com/"
    private val okHttpCacheSize = 10 * 1024 * 1024L

    @Provides
    @Singleton
    fun provideOkHttpCache(app: Application): Cache {
        return Cache(app.cacheDir, okHttpCacheSize)
    }

    @Provides
    @Singleton
    fun provideOKHttpClient(cache: Cache): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(24, TimeUnit.SECONDS)
            .cache(cache)

        //httpClient.addInterceptor(connectivityInterceptor)

        //okhttp log
        /*if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BASIC)
            httpClient.addInterceptor(logging)
        }*/
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    /**
     *  API Services
     */

    @Provides
    @Singleton
    fun provideMovieInterface(retrofit: Retrofit): MovieInterface {
        return retrofit.create(MovieInterface::class.java)
    }
}