package com.tranbarret.movielist.features.popular

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tranbarret.movielist.di.AssistedSavedStateViewModelFactory
import com.tranbarret.movielist.domain.MovieRepository
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.util.Lawg
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel @AssistedInject constructor(
//    pager: Pager<Int, MovieEntity>,
    private val movieRepository: MovieRepository,
//    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<MovieListViewModel> {
        override fun create(savedStateHandle: SavedStateHandle) : MovieListViewModel
    }

    private var _movies = MutableStateFlow<List<Movie>>(listOf())
    val movies = _movies.asStateFlow()
    lateinit var movieList: List<Movie>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _movies.emit(movieRepository.getPopularMovies())
            movieList = movieRepository.getPopularMovies()
            Lawg.i("End of init")
        }
    }

//    init {
//        val string = savedStateHandle.contains("key")
//        Lawg.i(string.toString())
//    }

    fun saveState() {
        savedStateHandle["key"] = "value"
    }
}