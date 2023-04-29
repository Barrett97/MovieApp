package com.tranbarret.movielist.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tranbarret.movielist.domain.MovieRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class MovieDetailsViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}
