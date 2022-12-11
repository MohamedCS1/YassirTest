package com.example.yassirmovies.data

import com.example.yassirmovies.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieClient {
    private var baseUel:String = "https://api.themoviedb.org/3/"
    private var instance:MovieClient? = null
    private var moviesInterface:MoviesInterface? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUel)
            .addConverterFactory(GsonConverterFactory.create()).build()
        moviesInterface = retrofit.create(MoviesInterface::class.java)
    }

    fun getInstance():MovieClient
    {
        if (null == instance)
        {
            instance = MovieClient()
        }
        return instance!!
    }

    fun getMovies(apiKey:String):Call<Movies>
    {
        return moviesInterface!!.getTrendingMovies(apiKey)
    }


}