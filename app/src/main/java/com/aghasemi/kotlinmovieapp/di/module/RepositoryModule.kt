package com.aghasemi.kotlinmovieapp.di.module

import com.aghasemi.kotlinmovieapp.data.repository.MovieLocalDataSource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRemoteDataSource
import com.aghasemi.kotlinmovieapp.data.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {

    //Movie
    single { MovieRepository(get(), get()) }
    single { MovieRemoteDataSource(get()) }
    single { MovieLocalDataSource(get()) }
}