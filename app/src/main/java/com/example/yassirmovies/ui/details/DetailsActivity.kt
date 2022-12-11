package com.example.yassirmovies.ui.details

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.yassirmovies.R
import com.example.yassirmovies.databinding.ActivityDetailsBinding
import com.example.yassirmovies.helper.Utils
import com.example.yassirmovies.model.Movie
import kotlin.math.roundToInt

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailsBinding
    private lateinit var movie:Movie

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movie = intent.extras?.get("movie") as Movie

        Glide.with(this).load("https://image.tmdb.org/t/p/original/${movie.poster_path}").placeholder(R.drawable.ic_placeholder).apply(RequestOptions.bitmapTransform(RoundedCorners(14))).into(binding.imageViewPoster)

        binding.textViewOverview.text = movie.overview

        if (movie.original_title != null)
        {
            binding.textViewTitle.text = movie.original_title
        }else
        {
            binding.textViewTitle.text = movie.original_name
        }

        if (!movie.adult){binding.textViewIsAdult.visibility = View.GONE}

        val score = (movie.vote_average*10).roundToInt()

        binding.progressVoteAverage.progress = score

        binding.progressVoteAverage.progressTintList = Utils().getColorByUserScore(score)

        binding.textViewUserScore.text = "$score%"

        binding.buBack.setOnClickListener {
            onBackPressed()
        }
    }
}