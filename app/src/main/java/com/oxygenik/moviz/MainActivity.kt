package com.oxygenik.moviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.oxygenik.moviz.repositories.Repository
import com.oxygenik.moviz.screens.HomeScreen
import com.oxygenik.moviz.ui.theme.MovizTheme
import com.oxygenik.moviz.viewModels.MovieViewModel
import com.oxygenik.moviz.viewModels.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository()
        val viewModelFactory = MovieViewModelFactory(repository = repository)
        val movieViewModel = ViewModelProvider(
            owner = this, viewModelFactory
        )[MovieViewModel::class.java]
        
        setContent {
            MovizTheme {
                HomeScreen(viewModel = movieViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovizTheme {
        Greeting("Android")
    }
}