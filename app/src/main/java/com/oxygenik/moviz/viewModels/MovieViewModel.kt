package com.oxygenik.moviz.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oxygenik.moviz.BuildConfig
import com.oxygenik.moviz.repositories.Repository
import com.oxygenik.moviz.retrofit.Movie
import kotlinx.coroutines.launch


/**
 * ViewModel: Stores and Manages UI-related Data
 * surviving configuration changes
 */
class MovieViewModel(repository: Repository) : ViewModel() {

    /*
     * ViewModel uses MutableStateOf<> instead of LiveData
     * allowing direct compose state handling
     *
     * When the value of movies changes, compose will automatically recompose the parts
     * of the UI that depend on this state
     */
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    // The online Movies
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    /*
     * View Model Scope launch a coroutine in the scope of ViewModel,
     * which means that coroutine will be tied to the lifecycle of the viewModel
     */
    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMoviesFromOnlineApi(BuildConfig.TMDB_API_KEY)
                // Assigning 'movies' to MoviesFromApi
                movies = moviesFromApi
            } catch (e: Exception) {
                // Fetch the data from ROOM DB
            }
        }

    }

}