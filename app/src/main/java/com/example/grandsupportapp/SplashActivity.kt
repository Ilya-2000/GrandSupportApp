package com.example.grandsupportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        var img = findViewById<ImageView>(R.id.splash_img)
        img.startAnimation(anim)

        var handler = Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2500)
    }
}
