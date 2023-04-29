package com.tranbarret.movielist.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.tranbarret.movielist.domain.models.Movie
import retrofit2.http.GET

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertAll(movies: ArrayList<Movie>)

    @Query("SELECT * FROM movie")
    suspend fun getMovies() : List<Movie>

    @Query("DELETE FROM movieentity")
    suspend fun clearAll()
}