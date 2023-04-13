package com.tranbarret.movielist.di.modules

import com.tranbarret.movielist.MovieApplication
import dagger.Module
import dagger.Provides

@Module
class MovieListAppModule(
    private val app: MovieApplication
) {

    @Provides
    fun provideApplication(): MovieApplication = app

}