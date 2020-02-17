package com.example.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.grandsupportapp.R

class FiveManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_management)
        val nextBtn = findViewById<Button>(R.id.five_management_next_btn)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, SixManagementActivity::class.java))
        }
    }
}
