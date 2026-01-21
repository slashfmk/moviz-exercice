package com.oxygenik.moviz.screens

import androidx.compose.runtime.Composable
import com.oxygenik.moviz.viewModels.MovieViewModel


@Composable
fun HomeScreen(viewModel: MovieViewModel) {

    /*
     * No need for observeAsState, we're not using
     * LiveData, we're using MutableStateOf
     */
    val movieList = viewModel.movies
    MovieList(movies = movieList)

}