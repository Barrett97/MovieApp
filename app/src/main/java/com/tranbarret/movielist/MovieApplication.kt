package com.tranbarret.movielist

import android.app.Application
import com.tranbarret.movielist.di.DaggerMovieListAppComponent
import com.tranbarret.movielist.di.MovieListAppComponent

class MovieApplication : Application() {

    companion object {
        private var instance: MovieApplication? = null
        fun getInstance() = instance
            ?: throw IllegalStateException("Called getInstance before application was created")
    }

    init {
        instance = this
    }

    private var myComponent: MovieListAppComponent? = null

    fun getMovieListAppComponent(): MovieListAppComponent {
        val component = myComponent
        if (component == null) {
            createMovieListAppComponent().apply {
                myComponent = this
                return this
            }
        } else {
            return component
        }
    }

    private fun createMovieListAppComponent(): MovieListAppComponent {
        return DaggerMovieListAppComponent
            .builder()
            .build()
    }
 }