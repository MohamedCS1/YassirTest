package com.example.yassirmovies.ui.details

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yassirmovies.data.MoviesClient
import com.example.yassirmovies.model.DetailMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel(val application: Application):ViewModel() {

    val movieDetailsMutableLiveData = MutableLiveData<DetailMovieResponse>()

    fun getMoviesDetailsById(id:Int ,apiKey:String)
    {
        MoviesClient().getInstance().getMovieDetailsById(id ,apiKey).enqueue(object :Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                movieDetailsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Toast.makeText(application,"Something went wrong please try again" , Toast.LENGTH_SHORT).show()
            }
        })
    }
}