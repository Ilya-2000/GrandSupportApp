package com.example.grandsupportapp.smartphone.calls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.CallVPAdapter
import com.example.grandsupportapp.adapters.ToolsVPAdapter

class CallMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_main)
        val vp = findViewById<ViewPager>(R.id.call_vp)
        if (vp != null) {
            val adapter = CallVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
