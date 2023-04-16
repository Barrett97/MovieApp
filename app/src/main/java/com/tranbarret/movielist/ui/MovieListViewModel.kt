package com.tranbarret.movielist.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.squareup.inject.assisted.Assisted
import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.mappers.toMovie
import com.tranbarret.movielist.network.MovieApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    pager: Pager<Int, MovieEntity>,
//    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
//    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
//    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

//    val moviePagingFlow = pager
//        .flow
//        .map { pagingData ->
//            pagingData.map { it.toMovie() }
//        }
//        .cachedIn(viewModelScope)

}