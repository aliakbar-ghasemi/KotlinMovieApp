package com.aghasemi.kotlinmovieapp.di.module

import com.aghasemi.kotlinmovieapp.ui.home.HomeFragment
import com.aghasemi.kotlinmovieapp.ui.home.movieDetails.MovieDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailsFragment(): MovieDetailsFragment
}