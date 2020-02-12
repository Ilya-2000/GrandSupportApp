package com.example.grandsupportapp.bank.money_transfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.CommunalPaymentVPAdaprter
import com.example.grandsupportapp.adapters.TransferVPAdapter

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val vp = findViewById<ViewPager>(R.id.transfer_vp)
        if (vp != null) {
            val adapter = TransferVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
