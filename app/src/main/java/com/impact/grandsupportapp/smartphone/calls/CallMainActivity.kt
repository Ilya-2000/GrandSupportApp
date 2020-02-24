package com.impact.grandsupportapp.smartphone.calls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.adapters.CallVPAdapter

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
