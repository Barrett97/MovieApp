package com.tranbarret.movielist.di.modules

import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.network.MovieApi
import dagger.Module
import dagger.Provides

@Module
class MovieListAppModule(
    val app: MovieApplication,
    private val movieDatabase: MovieDatabase,
    private val movieApi: MovieApi
) {

    @Provides
    fun provideApplication(): MovieApplication = app

    @Provides
    fun provideMovieDatabase(): MovieDatabase = movieDatabase

    @Provides
    fun provideMovieApi(): MovieApi = movieApi

}