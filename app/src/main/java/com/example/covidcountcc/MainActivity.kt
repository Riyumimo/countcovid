package com.example.covidcountcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ng.max.slideview.SlideView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val slideView: SlideView = findViewById(R.id.slideview)
        slideView.setOnSlideCompleteListener { // vibrate the device
            // go to a new activity
            startActivity(Intent(this@MainActivity , SplashScreen::class.java))
        }
    }
}