package com.example.yassirmovies.ui.main

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yassirmovies.data.MoviesClient
import com.example.yassirmovies.model.MoviesResponse
import retrofit2.*

class MoviesViewModel(val application: Application):ViewModel() {


    val moviesResponseMutableLiveData = MutableLiveData<MoviesResponse>()

    fun getTrendingMovies(apiKey:String)
    {
        MoviesClient().getInstance().getTrendingMovies(apiKey).enqueue(object :
            Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                moviesResponseMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
              Toast.makeText(application,"Something went wrong please try again" ,Toast.LENGTH_SHORT).show()
            }
        })
    }
}