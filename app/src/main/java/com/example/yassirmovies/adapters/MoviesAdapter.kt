package com.example.yassirmovies.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.yassirmovies.R
import com.example.yassirmovies.model.Movie

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    var arrayMovies = arrayListOf<Movie>()
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        context = parent.context
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_movie ,parent ,false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.title.text = arrayMovies[position].title
        holder.releaseDate.text = arrayMovies[position].release_date
        Glide.with(context).load("https://image.tmdb.org/t/p/original/${arrayMovies[position].poster_path}").placeholder(R.drawable.ic_launcher_background).diskCacheStrategy(
            DiskCacheStrategy.ALL)
            .into(holder.imagePoster)
    }

    override fun getItemCount(): Int {
        return arrayMovies.size
    }

    class MoviesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val title = itemView.findViewById<TextView>(R.id.textViewTitle)
        val releaseDate = itemView.findViewById<TextView>(R.id.textViewReleaseDate)
        val imagePoster = itemView.findViewById<ImageView>(R.id.imageViewPoster)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoviesList(arrayOfMovies: ArrayList<Movie>)
    {
        this.arrayMovies = arrayOfMovies
        notifyDataSetChanged()
    }

}