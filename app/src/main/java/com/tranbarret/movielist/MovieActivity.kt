package com.tranbarret.movielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.tranbarret.movielist.databinding.MainActivityBinding
import com.tranbarret.movielist.network.TheMovieDbApiKeyInterceptor
import com.tranbarret.movielist.network.MovieApi
import com.tranbarret.movielist.util.Lawg
import kotlinx.coroutines.launch
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
        val navController = navHostFragment?.findNavController()


//        val baseUrl = "https://api.themoviedb.org"
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(TheMovieDbApiKeyInterceptor())
//            .cache(Cache(application.cacheDir, 5*1024*1024L))
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(MovieApi::class.java)
//
//        binding.call.setOnClickListener {
//            lifecycleScope.launch {
//                val response = retrofit.getPopularMovies(1)
////                Lawg.i(response.code().toString())
////                Lawg.i(response.isSuccessful.toString())
////                Lawg.i(response.body().toString())
//            }
//        }
    }
}