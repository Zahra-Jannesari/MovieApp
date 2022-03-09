package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.zarisa.netflixclone.databinding.FragmentProfileBinding
import com.zarisa.netflixclone.databinding.FragmentRegisterFormBinding


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private var sharedPrefInfo: SharedPreferences? = null
    lateinit var shareBtnState:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        setHasOptionsMenu(false)
        binding= FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Profile"
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        shareBtnState=this.requireActivity().getSharedPreferences("btnsState",Context.MODE_PRIVATE)
        setProfile()
        initViews()
    }

    private fun setProfile() {
        binding.textViewFullname.text = "Full Name: ${sharedPrefInfo?.getString(fullName,"")}"
        binding.textViewEmail.text = "Email: ${sharedPrefInfo?.getString(email,"")}"
        sharedPrefInfo?.getString(userName,"").let {
            if (it!="") {
                binding.textViewUsername.text = "Username: $it"
                binding.cardUsername.visibility=View.VISIBLE
            }
        }
        sharedPrefInfo?.getString(phone,"").let {
            if (it!="") {
                binding.textViewPhone.text = "Phone: $it"
                binding.cardPhone.visibility=View.VISIBLE
            }
        }
    }
    private fun initViews(){
        binding.buttonChangeInformation.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_registerFormFragment)
        }
        binding.buttonLogOut.setOnClickListener {
            val editor = sharedPrefInfo?.edit()
            editor?.putBoolean(isRegistered,false)
            editor?.putString(fullName,"")
            editor?.putString(email,"")
            editor?.putString(userName,"")
            editor?.putString(phone,"")
            editor?.apply()

            val editorBtns = shareBtnState.edit()
            editorBtns.putBoolean("11",false)
            editorBtns.putBoolean("12",false)
            editorBtns.putBoolean("13",false)
            editorBtns.putBoolean("21",false)
            editorBtns.putBoolean("22",false)
            editorBtns.putBoolean("23",false)
            editorBtns.putBoolean("31",false)
            editorBtns.putBoolean("32",false)
            editorBtns.putBoolean("33",false)
            editorBtns.putBoolean("41",false)
            editorBtns.putBoolean("42",false)
            editorBtns.putBoolean("43",false)
            editorBtns.apply()
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
    }
}