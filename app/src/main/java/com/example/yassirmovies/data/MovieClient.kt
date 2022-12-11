package com.example.yassirmovies.data

import com.example.yassirmovies.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieClient() {
    var BASEURL:String = "https://api.themoviedb.org/3/"
    var INSTANSE:MovieClient? = null
    var MoviesInterface:MoviesInterface? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        MoviesInterface = retrofit.create(com.example.yassirmovies.data.MoviesInterface::class.java)
    }

    fun getMovies(apiKey:String):Call<Movies>
    {
        return MoviesInterface!!.getTrendingMovies(apiKey)
    }


}