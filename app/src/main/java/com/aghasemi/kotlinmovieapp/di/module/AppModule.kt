package com.aghasemi.kotlinmovieapp.di.module

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
class AppModule {

}