package com.example.umbatmdbapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umbatmdbapplication.adapter.LatestMoviesAdapter
import com.example.umbatmdbapplication.apiKey
import com.example.umbatmdbapplication.databinding.FragmentLatestMovieBinding
import com.example.umbatmdbapplication.model.latestmovies.LatestMoviesModel
import com.example.umbatmdbapplication.util.ApiCallNetworkResource
import com.example.umbatmdbapplication.viemodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatestMovieFragment : Fragment() {
   private lateinit var _binding: FragmentLatestMovieBinding
   private val binding get() = _binding
    private lateinit var latestMoviesAdapter: LatestMoviesAdapter
    private lateinit var latestMovieRecyclerView: RecyclerView
    private lateinit var response:List<LatestMoviesModel>
    private val viewModel: MoviesViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLatestMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestMovieRecyclerView = binding.latestMovieRecyclerview
        initRecyclerView()
        observeApiCall()
        viewModel.getLatestMovies(apiKey)
    }


    // to initialize recyclerview
    private fun initRecyclerView(){
        latestMovieRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            latestMoviesAdapter = LatestMoviesAdapter()
            adapter = latestMoviesAdapter

        }
    }


    // function to observe register Live data
    private fun observeApiCall() {
        viewModel.latestMoviesResponseLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ApiCallNetworkResource.Success -> {
//                    binding.viewCover.visibility = View.GONE
//                    binding.registerProgressBar.visibility = View.GONE
                    if (it == null) {
                        Toast.makeText(requireContext(), "no result found", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        response = it.data!!
                      latestMoviesAdapter.listOfLatestMovies = response.toMutableList() as ArrayList<LatestMoviesModel>
                     //  latestMoviesAdapter.setUpdatedData(it.data as ArrayList<LatestMoviesModel> )
                    }
                }

                is ApiCallNetworkResource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
//                    binding.viewCover.visibility = View.GONE
//                    binding.registerProgressBar.visibility = View.GONE
                }

                is ApiCallNetworkResource.Loading -> {
//                    binding.viewCover.visibility = View.VISIBLE
//                    binding.registerProgressBar.visibility = View.VISIBLE
                }
            }
        }

    }
//
//
}