package com.example.umbatmdbapplication.dependencyinjection

import android.app.Application

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class MovieDatabaseModule {
//    @Singleton
//    @Provides
//    fun provideDatabaseInstance(context: Application): MovieDatabase{
//        return MovieDatabase.getDbInstance(context)
//    }
//
//
//    @Singleton
//    @Provides
//    fun provideLatestMovieDao(movieDatabase: MovieDatabase): LatestMoviesDao{
//        return movieDatabase.getLatestMovieDao()
//    }
//}