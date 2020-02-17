package com.example.grandsupportapp.smartphone.basic_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.grandsupportapp.R

class FourManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_management)
        val editText = findViewById<EditText>(R.id.editText)
        val nextBtn = findViewById<Button>(R.id.four_management_ok_btn)

        nextBtn.setOnClickListener {
            if (editText.text.contains("Андроид - это просто!")) {
                startActivity(Intent(this, FiveManagementActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Введите требуемый текст!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
