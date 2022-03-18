package com.example.umbatmdbapplication.model.latestmovies

import androidx.room.Entity
import androidx.room.PrimaryKey


//@Entity(tableName = "getLatestMovie")
data class LatestMoviesModel(
  //  @PrimaryKey(autoGenerate = true)
    val adult: Boolean,
    val backdrop_path: Any,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Int,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Int,
    val vote_count: Int
)