package com.tranbarret.movielist.domain

import com.tranbarret.movielist.domain.models.Movie

interface MovieRepository {
    suspend fun getPopularMovies() : List<Movie>
}

//class MoviesRepositoryImpl(
//    val movieApi: MovieApi,
//    val movieDao: MovieDao,
//    val movieDatabase: MovieDatabase
//) : MoviesRepository {
//    override suspend fun getPopularMovies(): Flow<Movie> {
//        movieApi.
//    }
//
//}