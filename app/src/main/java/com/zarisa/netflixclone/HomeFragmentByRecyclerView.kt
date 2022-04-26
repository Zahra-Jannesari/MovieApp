package com.zarisa.netflixclone

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
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
        setHasOptionsMenu(true)
        binding= FragmentHomeByRecyclerViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindRecyclerView()
    }

    private fun bindRecyclerView() {
        val movieAdapter = MovieListAdapter()
        binding.GridView.adapter = movieAdapter
        Repository.addTestDate()
        movieAdapter.setDate(Repository.movieList)
    }
    private fun favoriteBtnOnClick(button: ImageButton, movie:Movie){
        button.setSelected(!(button.isSelected))
        movie.isLiked=button.isSelected
//        if (button.isSelected){
//            button.isSelected = false
//            movie.isLiked=false
//        }
//        else{
//            button.isSelected = true
//            movie.isLiked=true
//        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_favorite->findNavController().navigate(R.id.action_homeFragmentByRecyclerView_to_favoriteByRecyclerViewFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}