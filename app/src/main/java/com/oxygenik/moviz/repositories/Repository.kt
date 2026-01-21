package com.oxygenik.moviz.repositories

import android.content.Context
import com.oxygenik.moviz.retrofit.Movie
import com.oxygenik.moviz.retrofit.RetrofitInstance
import com.oxygenik.moviz.room.MovieDAO
import com.oxygenik.moviz.room.MoviesDB

/**
 * Repository manages data operations and abstract the data sources.
 * Acts as a bridge between different data source (online DB, local DB, etc ...)
 * and rest of the app
 */
class Repository(context: Context) {

    // Fetching data from online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    // Fetching data from Offline Room database
    private val db = MoviesDB.getInstance(context)
    private val movieDao: MovieDAO = db.moviesDao

    suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesInDB()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>) {
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie: Movie) {
        return movieDao.insert(movie)
    }

}