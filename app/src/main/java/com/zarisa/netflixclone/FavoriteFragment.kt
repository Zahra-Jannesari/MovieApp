package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zarisa.netflixclone.databinding.FragmentFavoriteBinding

class FavoriteFragment() :Fragment(R.layout.fragment_favorite){
    private var sharedPrefInfo: SharedPreferences? = null
    lateinit var binding: FragmentFavoriteBinding
    private var registerState:Boolean?=false
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(false)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Favorites"
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        registerState=sharedPrefInfo?.getBoolean(isRegistered,false)
        setVisibilities()
    }

    private fun setVisibilities() {
        if(registerState==false){
            binding.textViewState.let {
                it.text="You should register first from profile page!"
                it.visibility=View.VISIBLE
            }
        }
        else {
            var hasFavorite=false
            binding.textViewState.visibility=View.GONE
            if (StateOfFavButtons.isBtn11Clicked || StateOfFavButtons.isBtn12Clicked || StateOfFavButtons.isBtn13Clicked) {
                hasFavorite=true
                binding.m1.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn11Clicked)
                    binding.m11.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn12Clicked)
                    binding.m12.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn13Clicked)
                    binding.m13.visibility=View.VISIBLE
            }
            if (StateOfFavButtons.isBtn21Clicked || StateOfFavButtons.isBtn22Clicked || StateOfFavButtons.isBtn23Clicked) {
                hasFavorite=true
                binding.m2.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn21Clicked)
                    binding.m21.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn22Clicked)
                    binding.m22.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn23Clicked)
                    binding.m23.visibility=View.VISIBLE
            }
            if (StateOfFavButtons.isBtn31Clicked || StateOfFavButtons.isBtn32Clicked || StateOfFavButtons.isBtn33Clicked) {
                hasFavorite=true
                binding.m3.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn31Clicked)
                    binding.m31.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn32Clicked)
                    binding.m32.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn33Clicked)
                    binding.m33.visibility=View.VISIBLE
            }
            if (StateOfFavButtons.isBtn41Clicked || StateOfFavButtons.isBtn42Clicked || StateOfFavButtons.isBtn43Clicked) {
                hasFavorite=true
                binding.m4.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn41Clicked)
                    binding.m41.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn42Clicked)
                    binding.m42.visibility=View.VISIBLE
                if (StateOfFavButtons.isBtn43Clicked)
                    binding.m43.visibility=View.VISIBLE
            }
            if (!hasFavorite){
                binding.textViewState.let {
                    it.text="You have no favorite!"
                    it.visibility=View.VISIBLE
                }
            }
        }
    }
}