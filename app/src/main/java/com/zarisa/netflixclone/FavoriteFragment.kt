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
    lateinit var shareBtnState:SharedPreferences
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
        shareBtnState=this.requireActivity().getSharedPreferences("btnsState",Context.MODE_PRIVATE)
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
            var is11Clicked=shareBtnState.getBoolean("11",false)
            var is12Clicked=shareBtnState.getBoolean("12",false)
            var is13Clicked=shareBtnState.getBoolean("13",false)

            var is21Clicked=shareBtnState.getBoolean("21",false)
            var is22Clicked=shareBtnState.getBoolean("22",false)
            var is23Clicked=shareBtnState.getBoolean("23",false)

            var is31Clicked=shareBtnState.getBoolean("31",false)
            var is32Clicked=shareBtnState.getBoolean("32",false)
            var is33Clicked=shareBtnState.getBoolean("33",false)

            var is41Clicked=shareBtnState.getBoolean("41",false)
            var is42Clicked=shareBtnState.getBoolean("42",false)
            var is43Clicked=shareBtnState.getBoolean("43",false)

            if (is11Clicked || is12Clicked || is13Clicked) {
                hasFavorite=true
                binding.m1.visibility=View.VISIBLE
                if (is11Clicked)
                    binding.m11.visibility=View.VISIBLE
                if (is12Clicked)
                    binding.m12.visibility=View.VISIBLE
                if (is13Clicked)
                    binding.m13.visibility=View.VISIBLE
            }
            if (is21Clicked || is22Clicked || is23Clicked) {
                hasFavorite=true
                binding.m2.visibility=View.VISIBLE
                if (is21Clicked)
                    binding.m21.visibility=View.VISIBLE
                if (is22Clicked)
                    binding.m22.visibility=View.VISIBLE
                if (is23Clicked)
                    binding.m23.visibility=View.VISIBLE
            }
            if (is31Clicked || is32Clicked || is33Clicked) {
                hasFavorite=true
                binding.m3.visibility=View.VISIBLE
                if (is31Clicked)
                    binding.m31.visibility=View.VISIBLE
                if (is32Clicked)
                    binding.m32.visibility=View.VISIBLE
                if (is33Clicked)
                    binding.m33.visibility=View.VISIBLE
            }
            if (is41Clicked || is42Clicked || is43Clicked) {
                hasFavorite=true
                binding.m4.visibility=View.VISIBLE
                if (is41Clicked)
                    binding.m41.visibility=View.VISIBLE
                if (is42Clicked)
                    binding.m42.visibility=View.VISIBLE
                if (is43Clicked)
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