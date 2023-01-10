package com.footstone22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.footstone22.databinding.ActivityLoadingBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class LoadingActivity : AppCompatActivity() {
    val splashScreen=3500
    private lateinit var binding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animasyon1 =AnimationUtils.loadAnimation(this,R.anim.loading_anim)
        val animasyon2 =AnimationUtils.loadAnimation(this,R.anim.loading_anim2)
        val animasyon3 =AnimationUtils.loadAnimation(this,R.anim.loading_anim3)
        val animasyon4 =AnimationUtils.loadAnimation(this,R.anim.loading_anim4)

        binding.apply {
            cardOne.animation =animasyon1
            cardTwo.animation=animasyon1
            cardThree.animation=animasyon1
            cardFour.animation=animasyon1

            cardFive.animation=animasyon2
            cardSix.animation=animasyon2
            cardSeven.animation=animasyon2
            cardEgiht.animation=animasyon2

            cardNine.animation=animasyon3
            cardTen.animation=animasyon3
            cardTwelve.animation=animasyon3
            cardEleven.animation=animasyon3

            cardThirtten.animation=animasyon4
            cardFourteen.animation=animasyon4
            cardFifteen.animation=animasyon4
            cardSixteen.animation=animasyon4
            footstone.animation=animasyon4

            //splashScreen
            Handler().postDelayed({
            val intent=Intent(this@LoadingActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            },splashScreen.toLong())
        }

    }
}