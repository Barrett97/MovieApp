package com.tranbarret.movielist.di

import android.app.Application
import android.content.Context
import com.tranbarret.movielist.MovieActivity
import com.tranbarret.movielist.di.modules.DispatcherModule
import com.tranbarret.movielist.di.modules.MovieListAppModule
import com.tranbarret.movielist.di.modules.NetworkModule
import com.tranbarret.movielist.di.modules.ViewModelModule
import com.tranbarret.movielist.features.popular.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    MovieListAppModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DispatcherModule::class
])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder
    }
    fun inject(activity: MovieActivity): MovieActivity
    fun inject(fragment: MovieListFragment): MovieListFragment
}