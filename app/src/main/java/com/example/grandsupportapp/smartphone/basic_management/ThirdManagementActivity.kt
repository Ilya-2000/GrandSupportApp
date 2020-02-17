package com.example.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.grandsupportapp.R

class ThirdManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_management)
        val nextBtn = findViewById<Button>(R.id.next_third_management_btn)

        nextBtn.setOnClickListener {
            startActivity(Intent(this, FourManagementActivity::class.java))
            finish()

        }
    }
}
