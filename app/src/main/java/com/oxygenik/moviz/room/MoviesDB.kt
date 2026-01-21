package com.oxygenik.moviz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oxygenik.moviz.retrofit.Movie
import kotlin.concurrent.Volatile


/**
 * Define the room database
 * and specifies its version
 */
@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {

    /*
     * Singleton Design pattern
     * Only one instance of the DB exists, avoiding
     * unnecessary multiple instances associated with
     * repeated DB creation
     */
    companion object {
        // Volatile: prevents any possible
        // race conditions in multithreading
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB {
            /*
             * Ensures that only one thread can execute the block
             * of code inside the synchronized block
             * at any given time
             */
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {

                    // creating the DB Object
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "Movies"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }
    }
}