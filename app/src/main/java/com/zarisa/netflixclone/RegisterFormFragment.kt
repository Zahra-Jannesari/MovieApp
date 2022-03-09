package com.zarisa.netflixclone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zarisa.netflixclone.databinding.FragmentRegisterFormBinding


class RegisterFormFragment : Fragment() {
    lateinit var binding:FragmentRegisterFormBinding
    private var sharedPrefInfo: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRegisterFormBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefInfo = this.activity?.getSharedPreferences("Information", Context.MODE_PRIVATE)
        binding.buttonRegister.setOnClickListener {
            if(validate()){
                saveInfo()
                findNavController().navigate(R.id.action_registerFormFragment_to_profileFragment)
            }
        }
    }
    private fun validate(): Boolean {
        var result=true
        if(binding.textFieldFullName.text.isBlank()){
            binding.textFieldFullName.error="Fill the field!"
            result=false
        }
        if(binding.textFieldEmail.text.isBlank()){
            binding.textFieldEmail.error="Fill the field!"
            result=false
        }
        return result
    }
    private fun saveInfo() {
        val editor = sharedPrefInfo?.edit()
        editor?.putBoolean(isRegistered,true)
        editor?.putString(fullName,binding.textFieldFullName.text.toString())
        editor?.putString(email,binding.textFieldEmail.text.toString())
        editor?.putString(userName, binding.textFieldUsername.text.toString())
        editor?.putString(phone,binding.textFieldPhone.text.toString())
        editor?.apply()

    }
}