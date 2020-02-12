package com.example.grandsupportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.contact_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }
}
