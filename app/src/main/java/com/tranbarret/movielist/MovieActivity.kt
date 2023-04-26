package com.tranbarret.movielist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.tranbarret.movielist.databinding.MainActivityBinding

class MovieActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MovieApplication.getInstance().appComponent.inject(this)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}