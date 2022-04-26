package com.zarisa.netflixclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageButton
import com.zarisa.netflixclone.adapter.Movie
import com.zarisa.netflixclone.adapter.MovieListAdapter
import com.zarisa.netflixclone.adapter.Repository
import com.zarisa.netflixclone.databinding.FragmentFavoriteByRecyclerViewBinding


class FavoriteByRecyclerViewFragment : Fragment() {
    lateinit var binding:FragmentFavoriteByRecyclerViewBinding
    lateinit var movieAdapter : MovieListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFavoriteByRecyclerViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bindRecyclerView()
    }

//    private fun bindRecyclerView() {
//        movieAdapter = MovieListAdapter()
//        binding.GridView.adapter = movieAdapter
//        Repository.fixLikedList()
//        movieAdapter.setDate(Repository.likedMovieList)
//    }
//    private fun favoriteBtnOnClick(button: ImageButton, movie: Movie){
//        button.setSelected(!(button.isSelected))
//        movie.isLiked=button.isSelected
//    }
}