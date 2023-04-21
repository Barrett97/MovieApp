package com.tranbarret.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.tranbarret.movielist.InjectingSavedStateViewModelFactory
import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.util.Lawg
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MovieListFragment : Fragment() {

    @Inject
    lateinit var abstractFactory: InjectingSavedStateViewModelFactory
    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MovieApplication.getInstance().appComponent.inject(this)
        val test = savedInstanceState?.getString("key1")
        Lawg.i(test.toString())
        val factory = abstractFactory.create(this, null)
        viewModel = ViewModelProvider(this, factory)[MovieListViewModel::class.java]

        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    Surface {
                        val moviee = viewModel.movies
                        val movies = viewModel.movieList
                        LazyColumn {
                            items(movies) { movie ->
                                movie.title?.let { Text(text = it) }
                            }
                        }
                    }
                }
            }
        }
    }

//    @Composable
//    fun PopularMovieListScreen(popularMovies: Flow<PagingData<Movie>>) {
//        popularMovies
//    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState()
        outState.putString("key1", "value1")
    }
}