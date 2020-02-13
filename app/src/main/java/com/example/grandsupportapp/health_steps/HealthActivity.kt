package com.example.grandsupportapp.health_steps

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.grandsupportapp.R
import com.github.barteksc.pdfviewer.PDFView

class HealthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)
        val pdfView = findViewById<PDFView>(R.id.health_pdf)
        val openWebsiteBtn = findViewById<Button>(R.id.open_website_btn)
        pdfView.fromAsset("health.pdf").load()

        openWebsiteBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://регистратура56.рф/")))
        }
    }
}
