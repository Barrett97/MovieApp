package com.tranbarret.movielist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [MovieEntity::class],
    version = 1
)
@TypeConverters()
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}