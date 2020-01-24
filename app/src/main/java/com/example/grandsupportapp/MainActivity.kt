package com.example.grandsupportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val smartphoneBtn = findViewById<Button>(R.id.smartphone_btn)
        val regBtn = findViewById<Button>(R.id.reg_btn)
        val doctorBtn = findViewById<Button>(R.id.doctor_btn)
        val socBtn = findViewById<Button>(R.id.soc_btn)
        val zhkhBtn = findViewById<Button>(R.id.zhkh_btn)
        val mobileBankBtn = findViewById<Button>(R.id.mob_bank_btn)

        smartphoneBtn.setOnClickListener {
            //startActivity(Intent())
        }

    }
}
