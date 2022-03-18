package com.example.umbatmdbapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel

//@Dao
//interface LatestMoviesDao {
//    // Add latest movie to the database
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addLatestMovie(latestMovie: LatestMoviesModel)
//
//
//    //get latest movies from Database
//    @Query("SELECT * FROM getLatestMovie")
//    fun getLatestMovieFromDB(): LiveData<List<LatestMoviesModel>>
//}