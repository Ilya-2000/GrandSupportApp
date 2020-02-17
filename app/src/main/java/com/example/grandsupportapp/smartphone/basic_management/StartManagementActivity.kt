package com.example.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import com.example.grandsupportapp.R
import kotlinx.android.synthetic.main.activity_start_management.*

class StartManagementActivity : AppCompatActivity() {
    var b = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_management)
        val switch = findViewById<Switch>(R.id.management_first_switch)
        val nextBtn = findViewById<Button>(R.id.next_management_btn)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                var drawable = resources.getDrawable(R.color.colorPrimary)
                b = isChecked
                nextBtn.background = drawable
            } else {
                var drawable = resources.getDrawable(R.color.divider)
                b = false
                nextBtn.background = drawable
            }
        }

        nextBtn.setOnClickListener {
            if (b) {
                startActivity(Intent(this, FirstManagementActivity::class.java))
                finish()
            } else {
                Toast.makeText(this,"Включите перключатель", Toast.LENGTH_LONG).show()
            }
        }
    }


}
