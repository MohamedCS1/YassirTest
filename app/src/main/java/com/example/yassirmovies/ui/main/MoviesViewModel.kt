package com.example.yassirmovies.ui.main

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yassirmovies.data.MovieClient
import com.example.yassirmovies.model.Movies
import retrofit2.*

class MoviesViewModel(val application: Application):ViewModel() {


    val moviesMutableLiveData = MutableLiveData<Movies>()

    fun getTrendingMovies()
    {
        MovieClient().getInstance().getMovies("c9856d0cb57c3f14bf75bdc6c063b8f3").enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                moviesMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
              Toast.makeText(application,"something went wrong please try again" ,Toast.LENGTH_SHORT).show()
            }
        })
    }
}