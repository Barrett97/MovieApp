package com.tranbarret.movielist.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tranbarret.movielist.data.local.Genres
import com.tranbarret.movielist.domain.models.Genre
import java.util.Arrays

class Converters {

    @TypeConverter
    fun genresToString(genres: ArrayList<Genre>) : String {
//        var value = ""
//
//        for (genre in genres.genres)
//            value += "$genre,"
//
//        return value
        return genres.toString()
    }
    @TypeConverter
    fun stringToGenre(string: String) : ArrayList<Genre> {
//        val genres = string.split("\\s*,\\s*")
//        return Genres(genres)
        return listOf<Genre>(string.split(","))
    }
}