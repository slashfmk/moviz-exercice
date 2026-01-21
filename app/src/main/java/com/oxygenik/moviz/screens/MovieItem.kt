package com.oxygenik.moviz.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.oxygenik.moviz.retrofit.Movie
import com.oxygenik.moviz.ui.theme.MovizTheme


@Composable
fun MovieItem(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        // https://media.themoviedb.org/t/p/w600_and_h900_face/6igvNs5VJB4ryBLgjjXksDVs0Fm.jpg
        // https://image.tmdb.org/t/p/w500/6igvNs5VJB4ryBLgjjXksDVs0Fm.jpg
        // model = "https://media.themoviedb.org/t/p/w600/${movie.posterPath}",
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
            contentDescription = "Movie desc",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(200.dp)
                .height(250.dp)
        )

//        Box(
//            modifier = Modifier
//                .width(200.dp)
//                .height(250.dp)
//                .background(Color.Black)
//        )

        Spacer(modifier = Modifier.width(10.dp))

        Column() {
            Text(
                text = movie.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${movie.overview.take(110)} ...",
                textAlign = TextAlign.Left,
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(text = movie.voteCount.toString())
            Text(text = movie.originalLanguage)
        }
    }
}


@Composable
@Preview(
    showSystemUi = true
)
fun PreviewMovieItem() {

    val movie = Movie(
        id = 2,
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