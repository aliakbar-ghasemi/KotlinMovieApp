package com.aghasemi.kotlinmovieapp

import android.app.Application
import com.aghasemi.kotlinmovieapp.di.module.databaseModule
import com.aghasemi.kotlinmovieapp.di.module.networkModule
import com.aghasemi.kotlinmovieapp.di.module.repositoryModule
import com.aghasemi.kotlinmovieapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                databaseModule,
                viewModelModule,
                repositoryModule
            )
        }
    }
}