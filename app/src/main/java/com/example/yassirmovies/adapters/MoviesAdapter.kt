package com.example.yassirmovies.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.yassirmovies.R
import com.example.yassirmovies.model.Movie
import kotlin.math.roundToInt

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    var arrayMovies = arrayListOf<Movie>()
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        context = parent.context
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_movie ,parent ,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        if (arrayMovies[position].original_title != null)
        {
            holder.title.text = arrayMovies[position].original_title
        }else
        {
            holder.title.text = arrayMovies[position].original_name
        }

        if (arrayMovies[position].release_date != null)
        {
            holder.releaseDate.text = arrayMovies[position].release_date
        }
        else
        {
            holder.releaseDate.text = arrayMovies[position].first_air_date
        }

        Glide.with(context).load("https://image.tmdb.org/t/p/original/${arrayMovies[position].poster_path}").placeholder(
            R.drawable.ic_placeholder
        ).diskCacheStrategy(
            DiskCacheStrategy.ALL).apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
            .into(holder.imagePoster)

        val score = (arrayMovies[position].vote_average*10).roundToInt()

        holder.progressVoteAverage.progress = (arrayMovies[position].vote_average*10).toInt()
        holder.progressVoteAverage.progressTintList = getColorByUserScore(score)
        holder.userScore.text = "${score}%"
    }

    fun getColorByUserScore(score:Int):ColorStateList
    {
        if (score < 70)
        {
            return ColorStateList.valueOf(Color.parseColor("#FFDF72"))
        }
        else if (score > 70)
        {
            return ColorStateList.valueOf(Color.parseColor("#61C688"))
        }
        return ColorStateList.valueOf(Color.WHITE)
    }

    override fun getItemCount(): Int {
        return arrayMovies.size
    }

    class MoviesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val title = itemView.findViewById<TextView>(R.id.textViewTitle)
        val releaseDate = itemView.findViewById<TextView>(R.id.textViewReleaseDate)
        val imagePoster = itemView.findViewById<ImageView>(R.id.imageViewPoster)
        val progressVoteAverage = itemView.findViewById<ProgressBar>(R.id.progressVoteAverage)
        val userScore = itemView.findViewById<TextView>(R.id.textViewUserScore)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoviesList(arrayOfMovies: ArrayList<Movie>)
    {
        this.arrayMovies = arrayOfMovies
        notifyDataSetChanged()
    }

}