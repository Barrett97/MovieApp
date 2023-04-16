package com.tranbarret.movielist.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.tranbarret.movielist.data.local.converters.Converters
import com.tranbarret.movielist.domain.models.Genre
import com.tranbarret.movielist.domain.models.ProductionCompany
import com.tranbarret.movielist.domain.models.ProductionCountry
import com.tranbarret.movielist.domain.models.SpokenLanguage

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
//    val belongs_to_collection: Any?,
    val budget: Int,
    val homepage: String,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
//    val production_companies: List<ProductionCompany>,
//    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
//    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
