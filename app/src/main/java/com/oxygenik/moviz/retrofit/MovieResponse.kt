package com.oxygenik.moviz.retrofit

import kotlinx.serialization.SerialName

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,

    @SerialName("total_pages")
    val total_pages: Int,

    @SerialName("total_results")
    val totalResults: Int
)
