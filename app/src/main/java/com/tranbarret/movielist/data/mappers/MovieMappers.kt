package com.tranbarret.movielist.data.mappers

import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.remote.MovieDto
import com.tranbarret.movielist.domain.models.Movie

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id,
        adult,
        backdrop_path,
        belongs_to_collection,
        budget,
        genres,
        homepage,
        imdb_id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies,
        production_countries,
        release_date,
        revenue,
        runtime,
        spoken_languages,
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count
    )
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id,
        adult,
        backdrop_path,
        belongs_to_collection,
        budget,
        genres,
        homepage,
        imdb_id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies,
        production_countries,
        release_date,
        revenue,
        runtime,
        spoken_languages,
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count
    )
}