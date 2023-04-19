package com.tranbarret.movielist.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tranbarret.movielist.AssistedSavedStateViewModelFactory
import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.mappers.toMovie
import com.tranbarret.movielist.util.Lawg
import kotlinx.coroutines.flow.map

class MovieListViewModel @AssistedInject constructor(
    pager: Pager<Int, MovieEntity>,
//    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
//    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<MovieListViewModel> {
        override fun create(savedStateHandle: SavedStateHandle) : MovieListViewModel
    }

    init {
        val string = savedStateHandle.contains("key")
        Lawg.i(string.toString())
    }

    fun saveState() {
        savedStateHandle["key"] = "value"
    }

    val moviePagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toMovie() }
        }
        .cachedIn(viewModelScope)
}