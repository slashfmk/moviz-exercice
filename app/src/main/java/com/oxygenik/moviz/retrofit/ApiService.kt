package com.oxygenik.moviz.retrofit

import retrofit2.http.GET
import retrofit2.http.Query


/*
 * Here is where you define the endpoints of your web service
 * Each method  represents an API call
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieResponse

}