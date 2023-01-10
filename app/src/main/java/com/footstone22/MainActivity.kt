package com.footstone22


import android.content.Intent
import android.media.MediaPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.footstone22.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.info.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this, InformationActivity::class.java)
            startActivity(intent)
        }
        binding.settings.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        binding.constraintLayout.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this, OpenActivity::class.java)
            startActivity(intent)
        }
        binding.collection.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this, CollectionsActivity::class.java)
            startActivity(intent)
        }
        binding.craft.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this, CraftActivity::class.java)
            startActivity(intent)
        }




    }
}