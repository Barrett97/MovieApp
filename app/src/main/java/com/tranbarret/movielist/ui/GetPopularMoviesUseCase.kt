package com.tranbarret.movielist.ui

import com.tranbarret.movielist.network.MovieApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class GetPopularMoviesUseCase @Inject constructor(
    @Named("movies") private val retrofit: Retrofit,
    private val movieApi: MovieApi
) {
}