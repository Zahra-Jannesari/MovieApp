package com.zarisa.netflixclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.zarisa.netflixclone.adapter.Movie
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
        val movieAdapter = MovieListAdapter(){button,movie ->favoriteBtnOnClick(button, movie)}
        binding.recyclerview.adapter = movieAdapter
        Repository.addTestDate()
        movieAdapter.submitList(Repository.movieList)
    }
    private fun favoriteBtnOnClick(button: ImageButton, movie:Movie){
        button.setSelected(!(button.isSelected))
        movie.isLiked=!(button.isSelected)
//        if (button.isSelected){
//            button.isSelected = false
//            movie.isLiked=false
//        }
//        else{
//            button.isSelected = true
//            movie.isLiked=true
//        }
    }
}