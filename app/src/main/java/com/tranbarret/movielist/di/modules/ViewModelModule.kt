package com.tranbarret.movielist.di.modules

import androidx.lifecycle.ViewModel
import com.tranbarret.movielist.AssistedSavedStateViewModelFactory
import com.tranbarret.movielist.ui.MovieListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindVMFactory(factory: MovieListViewModel.Factory) : AssistedSavedStateViewModelFactory<out ViewModel>
}

