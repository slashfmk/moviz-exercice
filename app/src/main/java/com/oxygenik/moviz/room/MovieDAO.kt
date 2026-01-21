package com.oxygenik.moviz.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.oxygenik.moviz.retrofit.Movie


/**
 * Bridge between the Room database and the rest of the App
 * Here, are defined all the database operations
 * such as INSERT, SELECT, UPDATE, and DELETE
 */
@Dao
interface MovieDAO {

    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM Movie")
    suspend fun getAllMoviesInDB(): List<Movie>

}