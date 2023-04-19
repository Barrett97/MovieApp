package com.tranbarret.movielist.di.modules

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.tranbarret.movielist.data.local.MovieDao
import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.data.local.MovieEntity
import com.tranbarret.movielist.data.remote.MovieRemoteMediator
import com.tranbarret.movielist.network.MovieApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class MovieListAppModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, "db")
            .build()

    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(moshiConverterFactory)
            .build()

    @Provides
    fun provideMovieDao(database: MovieDatabase) : MovieDao = database.movieDao

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit) : MovieApi =
        retrofit.create(MovieApi::class.java)

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideMoviePager(
        movieDatabase: MovieDatabase,
        movieApi: MovieApi
    ) : Pager<Int, MovieEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieDatabase, movieApi
            ),
            pagingSourceFactory = {
                movieDatabase.movieDao.pagingSource()
            }
        )
    }

}