package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.model.Movie
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.view.MovieItem
import com.example.movies.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
MovieList(movieList = movieViewModel.movieListResponse)

           movieViewModel.getMovieList()

                }
            }
        }
    }
}

@Composable
fun MovieList(movieList : List<Movie>){
    LazyColumn{
        itemsIndexed(items = movieList){
            index , item ->
            MovieItem(movie = item)
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    MoviesTheme {
        val movie = Movie(name = "Dev" , imageUrl = "",desc = "Hi guys welcome" , category = "ysddst")
        MovieItem(movie = movie)
    }
}