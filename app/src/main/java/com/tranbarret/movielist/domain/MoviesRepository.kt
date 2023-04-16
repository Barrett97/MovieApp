package com.tranbarret.movielist.domain

import com.tranbarret.movielist.data.local.MovieDao
import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.network.MovieApi
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getPopularMovies() : Flow<Movie>
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