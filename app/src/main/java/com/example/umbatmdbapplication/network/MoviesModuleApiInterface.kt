package com.example.umbatmdbapplication.network

import com.example.umbatmdbapplication.model.latestmoviesclass.LatestMoviesResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesModuleApiInterface {
    @GET("movie/latest")
    suspend fun getLatestMovies(@Query("api_key") apiKey: String):Response<LatestMoviesResponse>

}