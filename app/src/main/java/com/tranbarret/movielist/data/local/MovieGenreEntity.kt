package com.tranbarret.movielist.data.local

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    foreignKeys =
    [
        ForeignKey(
            entity = MovieEntity::class,
            parentColumns = ["id"],
            childColumns = ["movie_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieGenreEntity(
    val movie_id: Int,
    val genre: String
)