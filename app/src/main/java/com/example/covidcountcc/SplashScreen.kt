package com.example.covidcountcc

import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import ng.max.slideview.SlideView

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val slideView: SlideView = findViewById(R.id.slideview)
        slideView.setOnSlideCompleteListener { // vibrate the device
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(100)
            // go to a new activity
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
        }
    }
}