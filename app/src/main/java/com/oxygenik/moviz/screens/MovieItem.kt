package com.oxygenik.moviz.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.oxygenik.moviz.retrofit.Movie
import com.oxygenik.moviz.ui.theme.MovizTheme


@Composable
fun MovieItem(movie: Movie) {
    Column() {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
            contentDescription = movie.overview
        )
        Text(text = movie.title)
        Text(text = movie.overview)
        Text(text = movie.voteCount.toString())
        Text(text = movie.originalLanguage)
    }
}


@Composable
@Preview(
    showSystemUi = true
)
fun PreviewMovieItem() {

    val movie = Movie(
        adult = false,
        overview = "Great movie",
        title = "Game Over",
        releaseDate = "01/25/2025",
        posterPath = "6igvNs5VJB4ryBLgjjXksDVs0Fm.jpg",
        voteCount = 35558,
        originalLanguage = "English"
    )

    MovizTheme {
        MovieItem(movie = movie)
    }
}