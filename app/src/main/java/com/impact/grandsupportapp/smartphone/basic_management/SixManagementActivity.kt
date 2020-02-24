package com.impact.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.impact.grandsupportapp.R

class SixManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_management)

        val nextBtn = findViewById<Button>(R.id.six_management_next_btn)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, FinalManagementActivity::class.java))
            finish()
        }
    }
}
