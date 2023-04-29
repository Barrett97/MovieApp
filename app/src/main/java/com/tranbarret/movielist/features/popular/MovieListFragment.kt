package com.tranbarret.movielist.features.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.tranbarret.movielist.di.InjectingSavedStateViewModelFactory
import com.tranbarret.movielist.MovieApplication
import com.tranbarret.movielist.R
import com.tranbarret.movielist.domain.models.Movie
import com.tranbarret.movielist.theme.MovieTheme
import com.tranbarret.movielist.util.Lawg
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
                MovieTheme {
                    Surface {
                        val movieList by viewModel.movies.collectAsState()
                        LaunchedEffect(key1 = movieList, block = {
                            Lawg.i("Got " + movieList.size + " movies")
                        })
                        PopularMovieListScreen(movieList = movieList)
                    }
                }
            }
        }
    }

    @Composable
    fun PopularMovieListScreen(movieList: List<Movie>) {
        LazyColumn {
            items(movieList) { movie ->
                MovieCard(movie = movie)
            }
        }
    }

    @Composable
    fun MovieCard(movie: Movie) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 4.dp, 4.dp, 4.dp)
                .heightIn(0.dp, 200.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Row(
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                        .diskCacheKey("movie_poster_${movie.posterPath}")
                        .networkCachePolicy(CachePolicy.ENABLED)
                        .diskCachePolicy(CachePolicy.DISABLED)
                        .memoryCachePolicy(CachePolicy.ENABLED)
                        .build(),
                    placeholder = painterResource(id = R.drawable.baseline_local_movies_24),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 4.dp)
                ) {
                    Text(modifier = Modifier.align(CenterHorizontally)
                        ,text = movie.title, fontWeight = FontWeight.Bold)
                    movie.overview?.let {
                        Text(text = it,
                        fontWeight = FontWeight.Light,
                        overflow = TextOverflow.Ellipsis)
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