package com.footstone22


import android.content.Context
import android.content.Intent

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.media.MediaPlayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.footstone22.databinding.ActivitySettingBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        val locale =
            Locale(getLocaleSharedPreferances())// shared preferances'a en son hangi dil değerini yazmışsak, uygulamayı o dilde açıyor, uygulama ilk defa açılıyorsa, default olan Türkçe ile açılıyor.
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        setContentView(binding.root)

        landscape()
        openlanguage()

        binding.imageviewHome4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.info.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).stop()
        }

    }

    private fun openlanguage() {

        binding.imageEn.setOnClickListener {
            val snack = Snackbar.make(it, "Language is en", Snackbar.LENGTH_SHORT)
                .show()
            setLocale("")
        }
        binding.imagePort.setOnClickListener {
            val snack = Snackbar.make(it, "Language is Pt", Snackbar.LENGTH_SHORT)
                .show()
            setLocale("pt")
            
        }
    }

    fun setLocale(selectedLocale: String) {
        val locale =
            Locale(selectedLocale) //butonlar içerisinden fonksiyonumuz çağırılırken, gönderdiğimiz parametreye göre lokalimizi ayarladık.
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        writeLocaleSharedPreferances(selectedLocale)//dil seçimini cihaza kaydedecek fonksiyonu çağırıyoruz.
        finish()//mevcut acivity i bitir.
        startActivity(intent)//activity i baştan yükle
 //seçilen dili toast mesaj olarak yaz
    }

    fun writeLocaleSharedPreferances(selectedLocale: String) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(
            "selectedLocale",
            selectedLocale
        )// seçilen dili shared preferances'a yazıyoruz ki, uygulamamız sonraki açılışlarda en son seçilen dil ile açılsın.
        editor.commit()
    }


    fun getLocaleSharedPreferances(): String? {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getString("selectedLocale", "")
    }


    private fun landscape() {
        var isProtrait = true
        binding.settings.setOnClickListener {
            if (isProtrait) {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            } else {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
            }
            isProtrait = !isProtrait


        }


    }
}







