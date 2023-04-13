package com.tranbarret.movielist.di

import com.tranbarret.movielist.MovieActivity
import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.di.modules.MovieListAppModule
import com.tranbarret.movielist.network.MovieApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MovieListAppModule::class])
interface MovieListAppComponent {
    fun inject(activity: MovieActivity): MovieActivity

    fun inject(movieDatabase: MovieDatabase): MovieDatabase
    fun inject(movieApi: MovieApi): MovieApi
}