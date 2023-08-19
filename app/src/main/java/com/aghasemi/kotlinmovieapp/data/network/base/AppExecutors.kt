package com.aghasemi.kotlinmovieapp.data.network.base

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors private constructor() {
    // do the db operations on the cache
    // insert/ update/ delete on cache
    fun diskIO(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    fun networkIO(): Executor {
        return Executors.newScheduledThreadPool(3)
    }

    // send information to main thread
    fun mainThread(): Executor {
        return MainThreadExecutor()
    }

    // this call is going to post things to main thread
    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    companion object {
        private var sInstance: AppExecutors? = null
        val instance: AppExecutors?
            get() {
                if (sInstance == null) sInstance = AppExecutors()
                return sInstance
            }
    }
}