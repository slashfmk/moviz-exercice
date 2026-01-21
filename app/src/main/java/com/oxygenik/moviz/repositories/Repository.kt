package com.oxygenik.moviz.repositories

import com.oxygenik.moviz.retrofit.Movie
import com.oxygenik.moviz.retrofit.RetrofitInstance

/*
 * Repository manages data operations and abstract the data sources.
 * Acts as a bridge between different data source (online DB, local DB, etc ...)
 * and rest of the app
 */
class Repository {

    // Fetching data from online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}