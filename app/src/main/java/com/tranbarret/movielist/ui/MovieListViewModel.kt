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
import com.tranbarret.movielist.domain.MovieRepository
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.util.Lawg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MovieListViewModel @AssistedInject constructor(
//    pager: Pager<Int, MovieEntity>,
    private val movieRepository: MovieRepository,
//    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<MovieListViewModel> {
        override fun create(savedStateHandle: SavedStateHandle) : MovieListViewModel
    }

    private var _movies = MutableSharedFlow<List<Movie>>()
    val movies = _movies.asSharedFlow()
    lateinit var movieList: List<Movie>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _movies.emit(movieRepository.getPopularMovies())
            movieList = movieRepository.getPopularMovies()
        }
    }

    init {
        val string = savedStateHandle.contains("key")
        Lawg.i(string.toString())
    }

    fun saveState() {
        savedStateHandle["key"] = "value"
    }

//    val moviePagingFlow = pager
//        .flow
//        .map { pagingData ->
//            pagingData.map { it.toMovie() }
//        }
//        .cachedIn(viewModelScope)
}