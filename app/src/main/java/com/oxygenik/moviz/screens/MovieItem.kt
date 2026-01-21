package com.oxygenik.moviz.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
            contentDescription = "Movie desc",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .width(200.dp)
                .height(250.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column() {
            Text(
                text = movie.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = movieLengthShorten(movie.overview),
                textAlign = TextAlign.Left,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(text = movie.voteCount.toString())
            Text(text = movie.originalLanguage)
        }
    }
}

fun movieLengthShorten(text: String): String {
    return if (text.length > 200) "${text.take(200)} ..." else text
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