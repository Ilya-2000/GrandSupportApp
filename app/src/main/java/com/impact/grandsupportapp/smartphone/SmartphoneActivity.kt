package com.impact.grandsupportapp.smartphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.smartphone.basic_management.StartManagementActivity
import com.impact.grandsupportapp.smartphone.calls.CallMainActivity
import com.impact.grandsupportapp.smartphone.settings_learn.SettingsMainActivity
import com.impact.grandsupportapp.smartphone.tools_learn.ToolsMainActivity

class SmartphoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smartphone)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_smartphone_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val settingsBtn = findViewById<CardView>(R.id.settings_smarphone_btn)
        val toolsBtn = findViewById<CardView>(R.id.tools_smartphone_btn)
        val callsBtn = findViewById<CardView>(R.id.call_smartphone_btn)
        val managementBtn = findViewById<CardView>(R.id.control_smartphone_btn)

        settingsBtn.setOnClickListener {
            startActivity(Intent(this, SettingsMainActivity::class.java))
        }

        toolsBtn.setOnClickListener {
            startActivity(Intent(this, ToolsMainActivity::class.java))
        }

        callsBtn.setOnClickListener {
            startActivity(Intent(this, CallMainActivity::class.java))
        }

        managementBtn.setOnClickListener {
            startActivity(Intent(this, StartManagementActivity::class.java))
        }

    }
}
