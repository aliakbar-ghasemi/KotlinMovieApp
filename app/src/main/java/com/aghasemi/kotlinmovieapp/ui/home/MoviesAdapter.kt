package com.aghasemi.kotlinmovieapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aghasemi.kotlinmovieapp.databinding.ItemMovieBinding
import com.aghasemi.kotlinmovieapp.model.Movie
import com.bumptech.glide.Glide

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.VH>() {

    private var movies = ArrayList<Movie>()

    fun setMovies(movieList: ArrayList<Movie>){
        this.movies = movieList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    class VH(private var binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.txtTitle.text = movie.title

            Glide.with(binding.root.context)
                .load(movie.poster)
                .into(binding.imgPoster)
        }
    }
}