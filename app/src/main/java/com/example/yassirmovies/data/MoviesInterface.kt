package com.example.yassirmovies.data

import com.example.yassirmovies.model.DetailMovieResponse
import com.example.yassirmovies.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.*

interface MoviesInterface {
    @GET("discover/movie")
    fun getTrendingMovies(@Query("api_key") apiKey:String):Call<MoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetailsById(@Path("movie_id") id:Int ,@Query("api_key") apiKey:String ):Call<DetailMovieResponse>
}