package com.oxygenik.moviz.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


/**
 * A singleton object that provides a centralized
 * & consistent configuration
 * for making network request using retrofit
 */
object RetrofitInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    // Kotlin Serialization configuration
    private val json = Json {
        ignoreUnknownKeys = true   // Prevent crashes from extra fields
        isLenient = true
        encodeDefaults = false
    }


    val api: ApiService by lazy {
        /**
         * by lazy: delays the initialization
         * of the property until it is first accessed.
         */
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        retrofit.create(ApiService::class.java)
    }

}