package com.tranbarret.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.ViewModelFactory
import com.tranbarret.movielist.databinding.MovieListBinding
import javax.inject.Inject

class MovieListFragment : Fragment() {


//    @Inject
//    internal lateinit var viewModelFactory: ViewModelProvider.Factory
//    private val viewModel by viewModels<MovieListViewModel> { viewModelFactory }
//    @Inject
//    lateinit var viewModel: MovieListViewModel
//    private val viewModel: MovieListViewModel by viewModels {
//        ViewModelFactory()
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val viewModel = ViewModelProvider(this, ViewModelFactory<MovieListViewModel>().create(MovieListViewModel::class.java))[MovieListViewModel::class.java]
//        MovieApplication.getInstance().getMovieListAppComponent().inject(this)
//        viewModel.moviePagingFlow

        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    Surface {

                        Text(modifier = Modifier.fillMaxSize(),
                            text = "Hello World!")
                    }
                }
            }
        }
    }
}