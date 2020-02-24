package com.impact.grandsupportapp.smartphone.settings_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.adapters.SettingsVPAdapter

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
