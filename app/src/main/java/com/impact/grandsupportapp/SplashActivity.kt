package com.impact.grandsupportapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.impact.grandsupportapp.smartphone.basic_management.StartManagementActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        var img = findViewById<ImageView>(R.id.splash_img)
        img.startAnimation(anim)

        var handler = Handler().postDelayed(Runnable {
            checkStart()
            finish()
        }, 2500)
    }

    fun checkStart() {
        var shared = getSharedPreferences("fstart", Context.MODE_PRIVATE)
        var isVisited: Boolean = shared.getBoolean("visited", false)
        if (!isVisited) {
            startActivity(Intent(this,StartManagementActivity::class.java))
            var editor = shared.edit()
            editor.putBoolean("visited", true)
            editor.apply()
        } else {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
