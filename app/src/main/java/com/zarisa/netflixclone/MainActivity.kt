package com.zarisa.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val isRegistered="isRegistered"
const val fullName="fullName"
const val email="email"
const val userName="userName"
const val phone="phone"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}