package com.tranbarret.movielist.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.network.MovieApi
import com.tranbarret.movielist.network.TheMovieDbApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [MovieListAppModule::class]
)
class NetworkModule {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org"
    }

    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideMoshi() : Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideNetworkInterceptor() : TheMovieDbApiKeyInterceptor =
        TheMovieDbApiKeyInterceptor()

    @Provides
    @Singleton
    fun provideOkHttp(
//        application: MovieApplication,
        theMovieDbApiKeyInterceptor: TheMovieDbApiKeyInterceptor
    ) : OkHttpClient = OkHttpClient.Builder()
//            .cache(Cache(application.cacheDir, 5*1024*1024L))
            .addNetworkInterceptor(theMovieDbApiKeyInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideMovieRetrofit(
        moshi: Moshi,
        gson: Gson,
        client: OkHttpClient
    ) : Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit) : MovieApi =
        retrofit.create(MovieApi::class.java)



}