package com.example.umbatmdbapplication.database
//
//import android.content.Context
//import androidx.room.*
//import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
//
//
//
//@Database(entities = [
//   LatestMoviesModel::class
//], version = 1, exportSchema = false)
//
//@TypeConverters(TypeConverter::class)
//abstract class MovieDatabase: RoomDatabase() {
//    abstract fun getLatestMovieDao(): LatestMoviesDao
//
//
//    //Creating a single instance of the database
//    companion object{
//        @Volatile
//        private var dbInstance: MovieDatabase? = null
//        private val lock = Any()
//
//        operator fun invoke(context: Context) = dbInstance?: synchronized(lock){
//            dbInstance?: getDbInstance(context)
//        }
//
//        fun getDbInstance(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            MovieDatabase::class.java,
//            "MovieDb"
//        ).build()
//    }
//}