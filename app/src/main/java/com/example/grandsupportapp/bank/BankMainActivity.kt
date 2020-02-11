package com.example.grandsupportapp.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.grandsupportapp.R
import com.example.grandsupportapp.bank.mobile_payment.MobilePaymentActivity

class BankMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_main)
        val mobilePaymentBtn = findViewById<CardView>(R.id.mobile_payment_bank_btn)
        val communalPayBtn = findViewById<CardView>(R.id.communal_bank_btn)

        mobilePaymentBtn.setOnClickListener {
            startActivity(Intent(this, MobilePaymentActivity::class.java))
        }

        communalPayBtn.setOnClickListener {
            startActivity(Intent(this, MobilePaymentActivity::class.java))
        }

    }
}
