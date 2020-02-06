package com.example.grandsupportapp.health_steps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.grandsupportapp.R
import com.github.barteksc.pdfviewer.PDFView

class HealthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)
        val pdfView = findViewById<PDFView>(R.id.health_pdf)
        pdfView.fromAsset("health.pdf").load()
    }
}
