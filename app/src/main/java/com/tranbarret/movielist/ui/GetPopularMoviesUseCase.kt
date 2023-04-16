package com.tranbarret.movielist.ui

import com.tranbarret.movielist.domain.MoviesRepository
import com.tranbarret.movielist.domain.models.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//class GetPopularMoviesUseCase @Inject constructor(
//    private val moviesRepository: MoviesRepository
//) {
//    suspend fun invoke() : Flow<Movie> = moviesRepository.getPopularMovies()
//}