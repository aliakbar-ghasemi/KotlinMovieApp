package com.aghasemi.kotlinmovieapp.ui.home.movieDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aghasemi.kotlinmovieapp.databinding.FragmentMovieDetailsBinding
import com.aghasemi.kotlinmovieapp.model.Movie
import com.aghasemi.kotlinmovieapp.ui.MainActivity
import com.bumptech.glide.Glide

class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding
    private var movie: Movie? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        handleArguments()
        return binding.root
    }

    private fun handleArguments() {
        val bundle = arguments
        movie = bundle?.getParcelable("movie")
        movie?.let { initUI(it) }
    }

    private fun initUI(movie: Movie) {
        //(activity as MainActivity).getToolbar().background = null

        binding.txtTitle.text = movie.title

        Glide.with(binding.root.context)
            .load(movie.poster)
            .into(binding.imgPoster)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }
}