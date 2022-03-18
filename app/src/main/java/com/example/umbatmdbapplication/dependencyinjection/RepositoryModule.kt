package com.example.umbatmdbapplication.dependencyinjection


import com.example.umbatmdbapplication.network.MoviesModuleApiInterface
import com.example.umbatmdbapplication.repository.MoviesRepository
import com.example.umbatmdbapplication.repository.MoviesRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMoviesRepository(moviesModuleApiInterface: MoviesModuleApiInterface
                                //latestMoviesDao: LatestMoviesDao
         ):MoviesRepositoryInterface{
        return MoviesRepository(moviesModuleApiInterface)
   // latestMoviesDao)
    }

}