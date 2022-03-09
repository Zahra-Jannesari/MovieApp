package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
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
    ): View {
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        (activity as AppCompatActivity).supportActionBar?.title = "NetflixClone"
        registerState=sharedPrefInfo?.getBoolean(isRegistered,false)
        favBtnsSetStateAndOnClick()
    }


    private fun favBtnsSetStateAndOnClick() {
        binding.btnFav11.setBackgroundResource(if (StateOfFavButtons.isBtn11Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav12.setBackgroundResource(if (StateOfFavButtons.isBtn12Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav13.setBackgroundResource(if (StateOfFavButtons.isBtn13Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav21.setBackgroundResource(if (StateOfFavButtons.isBtn21Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav22.setBackgroundResource(if (StateOfFavButtons.isBtn22Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav23.setBackgroundResource(if (StateOfFavButtons.isBtn23Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav31.setBackgroundResource(if (StateOfFavButtons.isBtn31Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav32.setBackgroundResource(if (StateOfFavButtons.isBtn32Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav33.setBackgroundResource(if (StateOfFavButtons.isBtn33Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav41.setBackgroundResource(if (StateOfFavButtons.isBtn41Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav42.setBackgroundResource(if (StateOfFavButtons.isBtn42Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav43.setBackgroundResource(if (StateOfFavButtons.isBtn43Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
        binding.btnFav11.setOnClickListener{
            if (registerState==true) {
                StateOfFavButtons.isBtn11Clicked = !StateOfFavButtons.isBtn11Clicked
                binding.btnFav11.setBackgroundResource(if (StateOfFavButtons.isBtn11Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav12.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn12Clicked = !StateOfFavButtons.isBtn12Clicked
            binding.btnFav12.setBackgroundResource(if (StateOfFavButtons.isBtn12Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav13.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn13Clicked = !StateOfFavButtons.isBtn13Clicked
            binding.btnFav13.setBackgroundResource(if (StateOfFavButtons.isBtn13Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }

        binding.btnFav21.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn21Clicked = !StateOfFavButtons.isBtn21Clicked
            binding.btnFav21.setBackgroundResource(if (StateOfFavButtons.isBtn21Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav22.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn22Clicked = !StateOfFavButtons.isBtn22Clicked
            binding.btnFav22.setBackgroundResource(if (StateOfFavButtons.isBtn22Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav23.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn23Clicked = !StateOfFavButtons.isBtn23Clicked
            binding.btnFav23.setBackgroundResource(if (StateOfFavButtons.isBtn23Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }

        binding.btnFav31.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn31Clicked = !StateOfFavButtons.isBtn31Clicked
            binding.btnFav31.setBackgroundResource(if (StateOfFavButtons.isBtn31Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav32.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn32Clicked = !StateOfFavButtons.isBtn32Clicked
            binding.btnFav32.setBackgroundResource(if (StateOfFavButtons.isBtn32Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav33.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn33Clicked = !StateOfFavButtons.isBtn33Clicked
            binding.btnFav33.setBackgroundResource(if (StateOfFavButtons.isBtn33Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }

        binding.btnFav41.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn41Clicked = !StateOfFavButtons.isBtn41Clicked
            binding.btnFav41.setBackgroundResource(if (StateOfFavButtons.isBtn41Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav42.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn42Clicked = !StateOfFavButtons.isBtn42Clicked
            binding.btnFav42.setBackgroundResource(if (StateOfFavButtons.isBtn42Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
        binding.btnFav43.setOnClickListener{
            if (registerState==true) {
            StateOfFavButtons.isBtn43Clicked = !StateOfFavButtons.isBtn43Clicked
            binding.btnFav43.setBackgroundResource(if (StateOfFavButtons.isBtn43Clicked) R.drawable.ic_baseline_favorite_selecte_24 else R.drawable.ic_baseline_favorite_notselect_24)
            }
            else notRegisterToast()
        }
    }

    private fun notRegisterToast(){
        Toast.makeText(activity,"You Have not registered yet!",Toast.LENGTH_SHORT).show()
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
}
