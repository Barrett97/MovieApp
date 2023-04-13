package com.tranbarret.movielist.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tranbarret.movielist.di.AssistedSavedStateViewModelFactory
import com.tranbarret.movielist.di.modules.IoDispatcher
import com.tranbarret.movielist.network.TheMovieDbService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val theMovieDbService: TheMovieDbService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
//    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}