package com.zarisa.netflixclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zarisa.netflixclone.adapter.MovieListAdapter
import com.zarisa.netflixclone.adapter.Repository
import com.zarisa.netflixclone.databinding.FragmentHomeByRecyclerViewBinding

class HomeFragmentByRecyclerView : Fragment() {
    lateinit var binding: FragmentHomeByRecyclerViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeByRecyclerViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindRecyclerView()
    }

    private fun bindRecyclerView() {
//        doctor ->goTODoctorPage(doctor.id)
        val movieAdapter = MovieListAdapter()
        binding.recyclerview.adapter = movieAdapter
        Repository.addTestDate()
        movieAdapter.submitList(Repository.movieList)
    }
}