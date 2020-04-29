package com.impact.grandsupportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smartphoneBtn: CardView = findViewById(R.id.smartphone_menu_btn)
        val regBtn: CardView = findViewById(R.id.reg_menu_btn)
        val healthBtn: CardView = findViewById(R.id.health_menu_btn)
        val socBtn: CardView = findViewById(R.id.social_menu_btn)

        val bankBtn: CardView = findViewById(R.id.mobile_bank_menu_btn)
        val contactsBtn: CardView = findViewById(R.id.contacts_menu_btn)


       /* smartphoneBtn.setOnClickListener {
            startActivity(Intent(this, SmartphoneActivity::class.java))
        }*/
        /*regBtn.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }*/
       /* healthBtn.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))

        }*/
       /* socBtn.setOnClickListener {
            startActivity(Intent(this, SocialNetworkActivity::class.java))
        }*/
       /* bankBtn.setOnClickListener {
            startActivity(Intent(this, BankMainActivity::class.java))

        }*/
        contactsBtn.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))

        }



    }


}
