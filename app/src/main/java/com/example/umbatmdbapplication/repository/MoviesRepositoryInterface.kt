package com.example.umbatmdbapplication.repository

import androidx.lifecycle.LiveData
import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
import com.example.umbatmdbapplication.model.latestmoviesclass.LatestMoviesResponse
import retrofit2.Response

interface MoviesRepositoryInterface {
    suspend fun getLatestMovies(apiKey: String): Response<LatestMoviesResponse>
//    fun getLatestMovieFromDb(): LiveData<List<LatestMoviesModel>>
//    suspend fun saveLatestMoviesToDb(movies: LatestMoviesModel)

}