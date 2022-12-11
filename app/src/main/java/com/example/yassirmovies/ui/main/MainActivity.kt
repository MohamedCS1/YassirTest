package com.example.yassirmovies.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.yassirmovies.adapters.MoviesAdapter
import com.example.yassirmovies.databinding.ActivityMainBinding
import com.example.yassirmovies.interfaces.MovieOnClickListener
import com.example.yassirmovies.model.Movie
import com.example.yassirmovies.model.MoviesResponse
import com.example.yassirmovies.ui.details.DetailsActivity


class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter:MoviesAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesViewModel:MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesAdapter = MoviesAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        moviesViewModel = MoviesViewModel(this.application)

        binding.recyclerViewMoviesTrending.adapter = moviesAdapter
        binding.recyclerViewMoviesTrending.layoutManager = linearLayoutManager
        moviesViewModel.getTrendingMovies("c9856d0cb57c3f14bf75bdc6c063b8f3")

        moviesViewModel.moviesResponseMutableLiveData.observe(this ,object :Observer<MoviesResponse>{
            override fun onChanged(moviesResponse: MoviesResponse) {
                moviesAdapter.setMoviesList(moviesResponse.results)
                binding.progressLoading.visibility = View.GONE
            }
        })

        moviesAdapter.onClickMovie(object :MovieOnClickListener{
            override fun onClick(movie: Movie) {
                val intent = Intent(this@MainActivity ,DetailsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("movie" ,movie)
                applicationContext.startActivity(intent)
            }
        })
    }
}