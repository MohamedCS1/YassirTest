package com.example.yassirmovies.data

import com.example.yassirmovies.model.Movies
import retrofit2.Call
import retrofit2.http.*

interface MoviesInterface {
    @GET("discover/movie")
    fun getTrendingMovies(@Query("api_key") apiKey:String):Call<Movies>
}