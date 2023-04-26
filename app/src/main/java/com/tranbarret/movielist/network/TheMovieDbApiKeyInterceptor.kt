package com.tranbarret.movielist.network

import com.tranbarret.movielist.BuildConfig
import com.tranbarret.movielist.util.Lawg
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class TheMovieDbApiKeyInterceptor : Interceptor {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
        const val CACHE_CONTROL_HEADER = "Cache-Control"
        const val CACHE_SIZE = 5 * 1024 * 1024L // 10MB
//        const val CACHE_SIZE = 5 * 1024 * 1024L
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()
        Lawg.i(
            String.format(
                "Sending request %s on %s%n%s",
                oldRequest.url, chain.connection(), oldRequest.headers
            )
        )
        val t1 = System.nanoTime()
        val oldUrl = oldRequest.url

        val newUrl = oldUrl.newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val cacheControl = CacheControl.Builder()
            .maxAge(10, TimeUnit.MINUTES)
            .build()

        val newRequest = oldRequest.newBuilder()
            .header(CACHE_CONTROL_HEADER, cacheControl.toString())
            .url(newUrl)
            .build()

        Lawg.i(newRequest.toString())


        val response = chain.proceed(newRequest)

        val t2 = System.nanoTime()
        Lawg.i(
            String.format(
                "Received response for %s in %.1fms%n%s",
                response.request.url, (t2 - t1) / 1e6, response.headers
            )
        )

//        Lawg.i(response.body().)

        return response;
    }
}
