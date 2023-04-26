package com.tranbarret.movielist.domain

import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.data.mappers.toMovie
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.network.MovieApi
import com.tranbarret.movielist.util.Lawg
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val moviesDatabase: MovieDatabase
) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        val pagedMovies = movieApi.getPopularMovies(1)
        Lawg.i(pagedMovies.body()?.results?.size.toString())
        val movies = pagedMovies.body()?.results
        val movieList = ArrayList<Movie>()
        if (movies != null) {
            for (movie in movies) {
                movieList.add(movie.toMovie())
            }
        }
        return movieList
    }
}