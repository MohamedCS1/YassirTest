package com.example.yassirmovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yassirmovies.R
import com.example.yassirmovies.adapters.MoviesAdapter
import com.example.yassirmovies.data.MovieClient
import com.example.yassirmovies.databinding.ActivityMainBinding
import com.example.yassirmovies.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var moviesAdapter:MoviesAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesAdapter = MoviesAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        mainViewModel = MainViewModel(this.application)

        binding.recyclerViewMoviesTrending.adapter = moviesAdapter
        binding.recyclerViewMoviesTrending.layoutManager = linearLayoutManager
        mainViewModel.getTrendingMovies()

        mainViewModel.moviesMutableLiveData.observe(this ,object :Observer<Movies>{
            override fun onChanged(movies: Movies) {
                moviesAdapter.setMoviesList(movies.results)
            }
        })
    }
}