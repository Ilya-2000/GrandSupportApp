package com.example.grandsupportapp.smartphone.settings_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.SettingsVPAdapter
import com.example.grandsupportapp.adapters.SocialNetworkVPAdapter

class SettingsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_main)

        val vp = findViewById<ViewPager>(R.id.settings_vp)
        if (vp != null) {
            val adapter = SettingsVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
