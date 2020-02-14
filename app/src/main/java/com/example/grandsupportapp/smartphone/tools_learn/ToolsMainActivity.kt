package com.example.grandsupportapp.smartphone.tools_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.SettingsVPAdapter
import com.example.grandsupportapp.adapters.ToolsVPAdapter

class ToolsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_main)
        val vp = findViewById<ViewPager>(R.id.tools_vp)
        if (vp != null) {
            val adapter = ToolsVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }

}
