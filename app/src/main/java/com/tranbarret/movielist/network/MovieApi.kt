package com.tranbarret.movielist.network

import com.tranbarret.movielist.domain.models.Configuration
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.domain.models.MovieListPaged
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi
{
    @GET("/configuration")
    suspend fun getUrlConfig() : Response<Configuration>

    @GET("/3/movie/550")
    suspend fun getMovie() : Response<Movie>

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int) : MovieListPaged

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int) : MovieListPaged
}