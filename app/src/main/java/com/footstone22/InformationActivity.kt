package com.footstone22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.footstone22.databinding.ActivityMain2Binding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageviewHome2.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}