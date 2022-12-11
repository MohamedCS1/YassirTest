package com.example.yassirmovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.yassirmovies.adapters.MoviesAdapter
import com.example.yassirmovies.databinding.ActivityMainBinding
import com.example.yassirmovies.model.Movies


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
                Log.d("currentResult",movies.results.toString())
                moviesAdapter.setMoviesList(movies.results)
                binding.progressLoading.visibility = View.GONE
            }
        })
    }
}