package com.example.grandsupportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.adapters.RegistrationVPAdapter

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val viewPager = findViewById<ViewPager>(R.id.gos_reg_vp)

        if (viewPager != null) {
            val adapter = RegistrationVPAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }
    }
}
