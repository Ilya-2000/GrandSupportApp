package com.impact.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.impact.grandsupportapp.R

class FirstManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_management)
        val nextBtn = findViewById<Button>(R.id.first_next_management_btn)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, SecondManagementActivity::class.java))
            finish()
        }
    }
}
