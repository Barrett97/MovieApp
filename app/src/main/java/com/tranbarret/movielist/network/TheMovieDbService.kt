package com.tranbarret.movielist.network

import com.tranbarret.movielist.model.Configuration
import com.tranbarret.movielist.model.Movie
import com.tranbarret.movielist.model.MovieListPaged
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService
{
    @GET("/configuration")
    suspend fun getUrlConfig() : Response<Configuration>

    @GET("/3/movie/550")
    suspend fun getMovie() : Response<Movie>

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int) : Response<MovieListPaged>

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int) : Response<MovieListPaged>
}