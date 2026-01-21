package com.oxygenik.moviz.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val adult: Boolean,

    @SerialName("original_language")
    val originalLanguage: String,

    val overview: String,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String,
    val title: String,

    @SerialName("vote_count")
    val voteCount: Int
)

/*
 *  All the fields from the original json
 *
 *
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
 */
