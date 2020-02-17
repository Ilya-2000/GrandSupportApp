package com.example.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.grandsupportapp.MainActivity
import com.example.grandsupportapp.R

class FinalManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_management)
        val nextBtn = findViewById<Button>(R.id.final_management_btn)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
    }
}
