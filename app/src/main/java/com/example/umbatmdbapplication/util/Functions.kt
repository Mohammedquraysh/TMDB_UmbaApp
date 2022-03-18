package com.example.umbatmdbapplication.util

object Functions {
    fun getUrlNumber(url:String):Int
    {
        val splitUrl = url.split("/")
        return splitUrl[splitUrl.lastIndex-1].toInt()
    }
}