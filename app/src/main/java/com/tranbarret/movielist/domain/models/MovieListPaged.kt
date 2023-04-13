package com.tranbarret.movielist.domain.models

import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.remote.MovieDto

data class MovieListPaged(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)