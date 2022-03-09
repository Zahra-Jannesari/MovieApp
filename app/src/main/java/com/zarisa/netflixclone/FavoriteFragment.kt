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
        removingFavorite()
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
    fun removingFavorite(){
        val editorBtns = shareBtnState.edit()
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
        binding.btnFav11.setOnClickListener{
            is11Clicked=!is11Clicked
            binding.btnFav11.setBackgroundResource(if (is11Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("11",is11Clicked)
            editorBtns.apply()
            binding.m11.visibility=View.GONE
            if (!is12Clicked&&!is13Clicked)
                binding.m1.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav12.setOnClickListener{
            is12Clicked=!is12Clicked
            binding.btnFav12.setBackgroundResource(if (is12Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("12",is12Clicked)
            editorBtns.apply()
            binding.m12.visibility=View.GONE
            if (!is11Clicked&&!is13Clicked)
                binding.m1.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav13.setOnClickListener{
            is13Clicked=!is13Clicked
            binding.btnFav13.setBackgroundResource(if (is13Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("13",is13Clicked)
            editorBtns.apply()
            binding.m13.visibility=View.GONE
            if (!is12Clicked&&!is11Clicked)
                binding.m1.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav21.setOnClickListener{
            is21Clicked=!is21Clicked
            binding.btnFav21.setBackgroundResource(if (is21Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("21",is11Clicked)
            editorBtns.apply()
            binding.m21.visibility=View.GONE
            if (!is22Clicked&&!is23Clicked)
                binding.m2.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav22.setOnClickListener{
            is22Clicked=!is22Clicked
            binding.btnFav22.setBackgroundResource(if (is22Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("22",is22Clicked)
            editorBtns.apply()
            binding.m22.visibility=View.GONE
            if (!is21Clicked&&!is23Clicked)
                binding.m2.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav23.setOnClickListener{
            is23Clicked=!is23Clicked
            binding.btnFav23.setBackgroundResource(if (is23Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("23",is23Clicked)
            editorBtns.apply()
            binding.m23.visibility=View.GONE
            if (!is22Clicked&&!is21Clicked)
                binding.m2.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav31.setOnClickListener{
            is31Clicked=!is31Clicked
            binding.btnFav31.setBackgroundResource(if (is31Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("31",is31Clicked)
            editorBtns.apply()
            binding.m31.visibility=View.GONE
            if (!is32Clicked&&!is33Clicked)
                binding.m3.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav32.setOnClickListener{
            is32Clicked=!is32Clicked
            binding.btnFav32.setBackgroundResource(if (is32Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("32",is32Clicked)
            editorBtns.apply()
            binding.m32.visibility=View.GONE
            if (!is31Clicked&&!is33Clicked)
                binding.m3.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav33.setOnClickListener{
            is33Clicked=!is33Clicked
            binding.btnFav33.setBackgroundResource(if (is33Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("33",is11Clicked)
            editorBtns.apply()
            binding.m33.visibility=View.GONE
            if (!is32Clicked&&!is31Clicked)
                binding.m3.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav41.setOnClickListener{
            is41Clicked=!is41Clicked
            binding.btnFav41.setBackgroundResource(if (is41Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("41",is41Clicked)
            editorBtns.apply()
            binding.m41.visibility=View.GONE
            if (!is42Clicked&&!is43Clicked)
                binding.m4.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav42.setOnClickListener{
            is42Clicked=!is42Clicked
            binding.btnFav42.setBackgroundResource(if (is42Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("42",is42Clicked)
            editorBtns.apply()
            binding.m42.visibility=View.GONE
            if (!is41Clicked&&!is43Clicked)
                binding.m4.visibility=View.GONE
            checkHaveFav()
        }
        binding.btnFav43.setOnClickListener{
            is43Clicked=!is43Clicked
            binding.btnFav43.setBackgroundResource(if (is43Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            editorBtns.putBoolean("43",is43Clicked)
            editorBtns.apply()
            binding.m43.visibility=View.GONE
            if (!is41Clicked&&!is42Clicked)
                binding.m4.visibility=View.GONE
            checkHaveFav()
        }

    }
    fun checkHaveFav(){
        if (binding.m1.visibility!=View.VISIBLE&&binding.m2.visibility!=View.VISIBLE
            &&binding.m2.visibility!=View.VISIBLE&&binding.m4.visibility!=View.VISIBLE){
            binding.textViewState.let {
                it.text="You have no favorite!"
                it.visibility=View.VISIBLE
            }
        }
    }
}