package com.example.yassirmovies.data

import com.example.yassirmovies.model.DetailMovieResponse
import com.example.yassirmovies.model.MoviesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesClient {
    private var baseUel:String = "https://api.themoviedb.org/3/"
    private var instance:MoviesClient? = null
    private var moviesInterface:MoviesInterface? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUel)
            .addConverterFactory(GsonConverterFactory.create()).build()
        moviesInterface = retrofit.create(MoviesInterface::class.java)
    }

    fun getInstance():MoviesClient
    {
        if (null == instance)
        {
            instance = MoviesClient()
        }
        return instance!!
    }

    fun getTrendingMovies(apiKey:String):Call<MoviesResponse>
    {
        return moviesInterface!!.getTrendingMovies(apiKey)
    }

    fun getMovieDetailsById(id:Int ,apiKey:String):Call<DetailMovieResponse>
    {
        return moviesInterface!!.getMovieDetailsById(id ,apiKey)
    }


}