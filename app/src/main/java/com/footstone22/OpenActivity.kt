package com.footstone22

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.footstone22.databinding.ActivityOpenBinding
import com.footstone22.model.LocalFootbalItem
import com.footstone22.viewmodel.FootballPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class OpenActivity : AppCompatActivity() {
    private val randofootballist = mutableListOf<LocalFootbalItem>()
    private lateinit var binding: ActivityOpenBinding
    private val mviewm: FootballPlayerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scaleballfun()
        emptyCardOpen()

        binding.imageviewHome3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.txtNext.setOnClickListener {
            randofootballist.let { veri ->
                mviewm.insertPlayer(veri)


            }
            val intent = Intent(this, CollectionsActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


    private fun scaleballfun() {
        binding.constranitlayoutt.apply {
            val aanimation = AnimationUtils.loadAnimation(this@OpenActivity, R.anim.scaleball)
            animation = aanimation
            setOnClickListener {
                aanimation.cancel()
                aanimation.reset()
                binding.constraintLayout3.visibility = View.GONE
                binding.linearArrowUp.visibility = View.GONE
                binding.linearArrowDown.visibility = View.GONE
                binding.constCard.visibility = View.VISIBLE

            }

        }
    }

    private fun emptyCardOpen() {
        mviewm.getallplayerviewModel()
        mviewm.getfootballist.observe(this, Observer { data ->
            data.get(0).topPlayers.shuffled().take(3).forEachIndexed { index, footballItem ->
                randofootballist.add(
                    LocalFootbalItem(
                        name = footballItem.player.name.toString(),
                        matches = footballItem.matches,
                        formattedValue = footballItem.formattedValue,
                        imageviewurl = "https://api.sofascore.com/api/v1/player/${footballItem.player.id}/image",
                        platerId = footballItem.player.id
                    )
                )
            }
        })
        binding.imageViewcardtwo.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            binding.imageViewcardtwo.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imageViewcardGreen.visibility = View.VISIBLE
            binding.txtNameTwo.visibility = View.VISIBLE
            binding.txtRandomOneMatch2.visibility = View.VISIBLE
            binding.txtRandomOneMatch3.visibility = View.VISIBLE
            binding.txtStar2.visibility = View.VISIBLE
            binding.imageViewCardOne2.visibility = View.VISIBLE
            val randomInt_two = Random.nextInt(20)


            binding.txtNameTwo.text = randofootballist.get(0).name.toString()
            binding.txtRandomOneMatch2.text =
                randofootballist.get(0).matches.toString()
            binding.txtRandomOneMatch3.text =
                randofootballist.get(0).formattedValue.toString()
            Glide.with(this)
                .load("https://api.sofascore.com/api/v1/player/${randofootballist[0].platerId}/image")
                .into(binding.imageViewCardOne2)


        }
        binding.imageViewcardthree.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            binding.imageViewcardthree.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imageViewcardBlue.visibility = View.VISIBLE
            binding.txtNameThree.visibility = View.VISIBLE
            binding.txtRandomOneMatch4.visibility = View.VISIBLE
            binding.txtRandomOneMatch5.visibility = View.VISIBLE
            binding.txtStar3.visibility = View.VISIBLE
            binding.imageViewCardOne3.visibility = View.VISIBLE
            val randomInt_three = Random.nextInt(20)


            binding.txtNameThree.text =
                randofootballist.get(1).name.toString()
            binding.txtRandomOneMatch4.text =
                randofootballist.get(1).matches.toString()
            binding.txtRandomOneMatch5.text =
                randofootballist.get(1).formattedValue.toString()
            Glide.with(this)
                .load("https://api.sofascore.com/api/v1/player/${randofootballist.get(1).platerId}/image")
                .into(binding.imageViewCardOne3)


        }


        binding.imagecardone.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            binding.imagecardone.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imagecardYellow.visibility = View.VISIBLE
            binding.txtNameOne.visibility = View.VISIBLE
            binding.txtDegerGoster.visibility = View.VISIBLE
            binding.txtMatchOneDeger.visibility = View.VISIBLE
            binding.txtStar.visibility = View.VISIBLE
            binding.imageViewCardOne.visibility = View.VISIBLE

            val randomInt = Random.nextInt(20)
            binding.txtNameOne.text = randofootballist.get(2).name.toString()
            binding.txtDegerGoster.text = randofootballist.get(2).matches.toString()
            binding.txtMatchOneDeger.text = randofootballist.get(2).formattedValue.toString()
            Glide.with(this)
                .load("https://api.sofascore.com/api/v1/player/${randofootballist.get(2).platerId}/image")
                .into(binding.imageViewCardOne)


        }
    }


}


// randofootballist.forEach {
//  mviewm.insertPlayer(it)

// }







