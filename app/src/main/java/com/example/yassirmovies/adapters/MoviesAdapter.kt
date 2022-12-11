package com.example.yassirmovies.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yassirmovies.R
import com.example.yassirmovies.model.Movie

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    var arrayMovies = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_movie ,parent ,false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.title.text = arrayMovies[position].title
        holder.releaseDate.text = arrayMovies[position].release_date
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