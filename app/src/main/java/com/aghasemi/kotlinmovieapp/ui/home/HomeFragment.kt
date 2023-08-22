package com.aghasemi.kotlinmovieapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aghasemi.kotlinmovieapp.R
import com.aghasemi.kotlinmovieapp.data.network.base.Failure
import com.aghasemi.kotlinmovieapp.data.network.base.Loading
import com.aghasemi.kotlinmovieapp.data.network.base.Success
import com.aghasemi.kotlinmovieapp.databinding.FragmentHomeBinding
import com.aghasemi.kotlinmovieapp.model.Movie
import java.util.ArrayList

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.getMovieList().observe(viewLifecycleOwner) {
            when (it) {
                is Failure -> {
                    Log.d("##TAG", "onCreateView: Failure")
                }

                is Loading -> {
                    Log.d("##TAG", "onCreateView: Loading")
                }

                is Success -> {
                    Log.d("##TAG", "onCreateView: Success" + it.data?.search)
                    it.data?.search?.let { movies -> updateMovies(movies) }
                }
            }
        }
        return root
    }

    private fun updateMovies(movies: ArrayList<Movie>) {
        val adapter = MoviesAdapter()
        adapter.setMovies(movies)
        adapter.setListener(object:MoviesAdapter.Listener{
            override fun onClick(movie: Movie) {
                Log.d("##TAG", "onClick: "+movie.title)
                val bundle = Bundle()
                bundle.putParcelable("movie", movie)
                findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment, bundle)
            }

        })
        binding.rvMovies.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}