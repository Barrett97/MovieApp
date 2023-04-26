package com.tranbarret.movielist.di.modules

import android.content.Context
import androidx.room.Room
import com.tranbarret.movielist.data.local.MovieDao
import com.tranbarret.movielist.data.local.MovieDatabase
import com.tranbarret.movielist.domain.MovieRepository
import com.tranbarret.movielist.domain.MovieRepositoryImpl
import com.tranbarret.movielist.network.MovieApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieListAppModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, "db")
            .build()

    @Provides
    fun provideMovieDao(database: MovieDatabase) : MovieDao = database.movieDao

    @Provides
    @Singleton
    fun provideMovieRepo(moveiApi: MovieApi, database: MovieDatabase) : MovieRepository =
        MovieRepositoryImpl(movieApi = moveiApi, database)


//    @OptIn(ExperimentalPagingApi::class)
//    @Provides
//    @Singleton
//    fun provideMoviePager(
//        movieDatabase: MovieDatabase,
//        movieApi: MovieApi
//    ) : Pager<Int, MovieEntity> {
//        return Pager(
//            config = PagingConfig(pageSize = 20),
//            remoteMediator = MovieRemoteMediator(
//                movieDatabase, movieApi
//            ),
//            pagingSourceFactory = {
//                movieDatabase.movieDao.pagingSource()
//            }
//        )
//    }

}