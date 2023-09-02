package com.aghasemi.kotlinmovieapp.di.module

import com.aghasemi.kotlinmovieapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}