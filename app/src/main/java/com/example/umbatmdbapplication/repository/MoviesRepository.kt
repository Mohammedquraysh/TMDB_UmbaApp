package com.example.umbatmdbapplication.repository

import androidx.lifecycle.LiveData

import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
import com.example.umbatmdbapplication.model.latestmoviesclass.LatestMoviesResponse
import com.example.umbatmdbapplication.network.MoviesModuleApiInterface
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesModuleApiInterface: MoviesModuleApiInterface
                                         //  private val latestMoviesDao: LatestMoviesDao
                                           ): MoviesRepositoryInterface {
    override suspend fun getLatestMovies(apiKey: String): Response<LatestMoviesResponse> {
        return moviesModuleApiInterface.getLatestMovies(apiKey)
    }

//    override fun getLatestMovieFromDb(): LiveData<List<LatestMoviesModel>> {
//        return latestMoviesDao.getLatestMovieFromDB()
//    }
//
//    override suspend fun saveLatestMoviesToDb(movies: LatestMoviesModel) {
//        latestMoviesDao.addLatestMovie(movies)
//    }

}