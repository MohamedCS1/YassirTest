package com.example.yassirmovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.yassirmovies.R
import com.example.yassirmovies.data.MovieClient
import com.example.yassirmovies.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MovieClient().getMovies("c9856d0cb57c3f14bf75bdc6c063b8f3").enqueue(object :Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                Log.d("CurrentResponse" , response.body()?.results!![0].title.toString())
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("CurrentResponse" ,t.message.toString())

            }
        })
    }
}