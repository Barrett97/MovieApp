package com.tranbarret.movielist.di

import com.tranbarret.movielist.MovieActivity
import com.tranbarret.movielist.di.modules.MovieListAppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MovieListAppModule::class])
interface MovieListAppComponent {
    fun inject(activity: MovieActivity): MovieActivity

}