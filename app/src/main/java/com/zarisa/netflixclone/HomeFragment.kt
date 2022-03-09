package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zarisa.netflixclone.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var sharedPrefInfo: SharedPreferences? = null
    private var registerState:Boolean?=false
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        (activity as AppCompatActivity).supportActionBar?.title = "NetflixClone"
        registerState=sharedPrefInfo?.getBoolean(isRegistered,false)
        var isButtonClicked = false
        binding.radio0.setOnClickListener{
                isButtonClicked = !isButtonClicked // toggle the boolean flag
                binding.radio0.setBackgroundResource(if (isButtonClicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_profile-> {
                if (registerState==true)
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                else
                    findNavController().navigate(R.id.action_homeFragment_to_registerFormFragment)
            }
            R.id.btn_favorite->findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
            R.id.btn_comeSoon->findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
        }
        return super.onOptionsItemSelected(item)
    }
    fun testFavoriteButton(){
//        DrawableCompat.setTint(binding.fbtn.drawable, ContextCompat.getColor(requireContext(),R.color.textColor));
//        val porterDuffColorFilter = PorterDuffColorFilter(
//            Color.BLUE,
//            PorterDuff.Mode.SRC_ATOP
//        )
//
//        binding.fbtn.drawable.colorFilter = porterDuffColorFilter
//        binding.fbtn.drawable.setColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN )
//binding.imageViewfav.setColorFilter(Color.RED,PorterDuff.Mode.OVERLAY)
    }
}