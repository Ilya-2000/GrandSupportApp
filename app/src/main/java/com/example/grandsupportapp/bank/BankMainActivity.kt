package com.example.grandsupportapp.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.grandsupportapp.R
import com.example.grandsupportapp.bank.communal_payment.CommunalPaymentActivity
import com.example.grandsupportapp.bank.mobile_payment.MobilePaymentActivity
import com.example.grandsupportapp.bank.money_transfer.TransferActivity

class BankMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_main)
        val mobilePaymentBtn = findViewById<CardView>(R.id.mobile_payment_bank_btn)
        val communalPayBtn = findViewById<CardView>(R.id.communal_bank_btn)
        val transferPayBtn = findViewById<CardView>(R.id.card_bank_btn)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_bank_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        mobilePaymentBtn.setOnClickListener {
            startActivity(Intent(this, MobilePaymentActivity::class.java))
        }

        transferPayBtn.setOnClickListener {
            startActivity(Intent(this, TransferActivity::class.java))
        }

        communalPayBtn.setOnClickListener {
            startActivity(Intent(this, CommunalPaymentActivity::class.java))
        }

    }
}
