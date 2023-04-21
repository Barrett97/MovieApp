package com.tranbarret.movielist.data.mappers

import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.remote.MovieDto
import com.tranbarret.movielist.domain.models.Movie

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        adult = adult,
        backdrop_path = backdrop_path,
//        belongs_to_collection = belongs_to_collection,
        budget = budget,
        homepage = homepage,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
//        production_companies = production_companies,
//        production_countries = production_countries,
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
//        spoken_languages = spoken_languages,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        adult = adult,
        backdropPath = backdrop_path,
//        belongs_to_collection = belongs_to_collection,
        budget = budget,
        homepage = homepage,
        imdbId = imdb_id,
        originalLanguage = original_language,
        originalTitle = original_title,
        overview = overview,
        popularity = popularity,
        posterPath = poster_path,
//        production_companies = production_companies,
//        production_countries = production_countries,
        releaseDate = release_date,
        revenue = revenue,
        runtime = runtime,
//        spoken_languages = spoken_languages,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = vote_average,
        voteCount = vote_count
    )
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        adult = adult,
        backdropPath = backdrop_path,
//        belongs_to_collection = belongs_to_collection,
        budget = budget,
        homepage = homepage,
        imdbId = imdb_id,
        originalLanguage = original_language,
        originalTitle = original_title,
        overview = overview,
        popularity = popularity,
        posterPath = poster_path,
//        production_companies = production_companies,
//        production_countries = production_countries,
        releaseDate = release_date,
        revenue = revenue,
        runtime = runtime,
//        spoken_languages = spoken_languages,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = vote_average,
        voteCount = vote_count
    )
}