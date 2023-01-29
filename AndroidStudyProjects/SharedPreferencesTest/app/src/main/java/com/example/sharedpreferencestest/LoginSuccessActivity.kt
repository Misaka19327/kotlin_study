package com.example.sharedpreferencestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferencestest.databinding.ActivityLoginSuccessBinding

class LoginSuccessActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}