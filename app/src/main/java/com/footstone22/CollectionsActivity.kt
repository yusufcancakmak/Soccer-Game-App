package com.footstone22

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.footstone22.databinding.ActivityCollectionsBinding
import com.footstone22.adapter.CardAdapter
import com.footstone22.adapter.MyCollectionsAdapter

import com.footstone22.viewmodel.FootballPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class CollectionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCollectionsBinding
    private lateinit var playeradapter: CardAdapter
    private lateinit var myCollectionsAdapter: MyCollectionsAdapter
    private lateinit var mydialog: Dialog
    private val viewmodell: FootballPlayerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myCollectionsAdapter = MyCollectionsAdapter()
        mydialog = Dialog(this)
        binding.imageViewHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.collectionsRv.visibility = View.GONE
        binding.rv.visibility = View.VISIBLE
        getRandomCard()
        binding.switchCollection.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                binding.rv.visibility = View.GONE
                binding.collectionsRv.visibility = View.VISIBLE
                setupRv()


            } else {
                binding.collectionsRv.visibility = View.GONE
                binding.rv.visibility = View.VISIBLE
                getRandomCard()


            }
        }
    }


    private fun setupRv() {
        playeradapter = CardAdapter()
        binding.collectionsRv.apply {
            layoutManager = LinearLayoutManager(this@CollectionsActivity)
            adapter = playeradapter


        }
        viewmodell.getallplayerviewModel()
        viewmodell.getfootballist.observe(this, Observer {
            playeradapter.playerlist = it
        })

    }


    private fun getRandomCard() {
        val randomInt_three = Random.nextInt(20)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@CollectionsActivity)
            adapter = myCollectionsAdapter
        }
        lifecycleScope.launchWhenStarted {
            viewmodell.getSavedPlayer().collect { data ->
                myCollectionsAdapter.favoritesList = data.chunked(3)

                Log.d("CollectionsActivity", data.distinctBy { response ->
                    resources.displayMetrics.toString()

                }.toString())

            }


        }


    }
}




