package com.tranbarret.movielist.model

data class MovieListPaged(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)