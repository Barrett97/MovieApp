package com.tranbarret.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tranbarret.movielist.InjectingSavedStateViewModelFactory
import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.util.Lawg
import javax.inject.Inject

class MovieListFragment : Fragment() {

    @Inject
    lateinit var abstractFactory: InjectingSavedStateViewModelFactory
    private lateinit var viewModel: MovieListViewModel

//    private val movieListViewModel by viewModel { component.homeViewModelFactory.create(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MovieApplication.getInstance().appComponent.inject(this)
//        val viewModel = ViewModelProvider(this, ViewModelFactory<MovieListViewModel>().create(MovieListViewModel::class.java))[MovieListViewModel::class.java]
//        MovieApplication.getInstance().getMovieListAppComponent().inject(this)
//        viewModel.bool
//        val args = bundleOf("s" to 2)
        val test = savedInstanceState?.getString("key1")
        Lawg.i(test.toString())
        val factory = abstractFactory.create(this, null)
        viewModel = ViewModelProvider(this, factory)[MovieListViewModel::class.java]


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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState()
        outState.putString("key1", "value1")
    }
}