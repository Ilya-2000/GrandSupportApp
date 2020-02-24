package com.impact.grandsupportapp.bank.mobile_payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.adapters.MobilePaymentVPAdapter

class MobilePaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_payment)
        val vp = findViewById<ViewPager>(R.id.mobile_payment_vp)
        if (vp != null) {
            val adapter = MobilePaymentVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
