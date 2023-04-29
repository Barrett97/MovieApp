package com.tranbarret.movielist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tranbarret.movielist.domain.models.Movie

@Database(
    entities = [MovieEntity::class,
               Movie::class],
    version = 1
)
@TypeConverters()
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}