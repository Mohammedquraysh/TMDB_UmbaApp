package com.example.umbatmdbapplication.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
import com.example.umbatmdbapplication.model.latestmoviesclass.LatestMoviesResponse
import com.example.umbatmdbapplication.repository.MoviesRepository
import com.example.umbatmdbapplication.util.ApiCallNetworkResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepository: MoviesRepository): ViewModel(){

    private val _latestMoviesResponseLiveData: MutableLiveData<ApiCallNetworkResource<LatestMoviesResponse>> = MutableLiveData()
    val latestMoviesResponseLiveData: LiveData<ApiCallNetworkResource<LatestMoviesResponse>> = _latestMoviesResponseLiveData



 //   fun getLatestMovieFromDb() = moviesRepository.getLatestMovieFromDb()
    /**Handling Errors For latest movies Network Call*/
    fun getLatestMovies (apiKey: String) {
        viewModelScope.launch {
            _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Loading())
            try {
                delay(1)
                val response = moviesRepository.getLatestMovies(apiKey)

                if (response.isSuccessful) {

                    _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Success(response.message(),response.body()))
                }else
                {
                    _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Error(response.message()))
                }

            } catch (e: Throwable) {
                e.printStackTrace()
                when(e){
                    is IOException ->{
                        _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Error( message =
                        "Network Failure, please check your internet connection"
                        ))
                    }
                    is NullPointerException ->{
                        _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Error(
                            "Invalid, please confirm again"
                        ))
                    }
                    else->{
                        _latestMoviesResponseLiveData.postValue(ApiCallNetworkResource.Error(message =
                        "an error occur please try again later"
                        ))
                    }
                }
            }
        }
    }


}