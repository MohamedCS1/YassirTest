package com.example.yassirmovies.ui.main

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yassirmovies.data.MovieClient
import com.example.yassirmovies.model.Movies
import kotlinx.coroutines.currentCoroutineContext
import retrofit2.*

class MainViewModel(val application: Application):ViewModel() {


    val moviesMutableLiveData = MutableLiveData<Movies>()

    fun getTrendingMovies()
    {
        MovieClient().getInstance().getMovies("c9856d0cb57c3f14bf75bdc6c063b8f3").enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                moviesMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("Error" ,t.message.toString())
              Toast.makeText(application,"something went wrong please try again" ,Toast.LENGTH_SHORT).show()
            }


        })
    }
}