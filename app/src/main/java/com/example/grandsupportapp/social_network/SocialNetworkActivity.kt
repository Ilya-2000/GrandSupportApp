package com.example.grandsupportapp.social_network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.CommunalPaymentVPAdaprter
import com.example.grandsupportapp.adapters.SocialNetworkVPAdapter

class SocialNetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_network)

        val vp = findViewById<ViewPager>(R.id.social_net_vp)
        if (vp != null) {
            val adapter = SocialNetworkVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
