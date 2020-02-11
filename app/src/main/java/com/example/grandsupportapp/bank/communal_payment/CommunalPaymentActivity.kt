package com.example.grandsupportapp.bank.communal_payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.CommunalPaymentVPAdaprter
import com.example.grandsupportapp.adapters.MobilePaymentVPAdapter

class CommunalPaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communal_payment)
        val vp = findViewById<ViewPager>(R.id.communal_payment_vp)
        if (vp != null) {
            val adapter = CommunalPaymentVPAdaprter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
