package com.example.grandsupportapp.bank

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.grandsupportapp.R
import com.example.grandsupportapp.bank.communal_payment.CommunalPaymentActivity
import com.example.grandsupportapp.bank.mobile_payment.MobilePaymentActivity
import com.example.grandsupportapp.bank.money_transfer.TransferActivity
import kotlinx.android.synthetic.main.full_img.*
import kotlinx.android.synthetic.main.info_bank.*

class BankMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_main)
        val mobilePaymentBtn = findViewById<CardView>(R.id.mobile_payment_bank_btn)
        val communalPayBtn = findViewById<CardView>(R.id.communal_bank_btn)
        val transferPayBtn = findViewById<CardView>(R.id.card_bank_btn)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_bank_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        mobilePaymentBtn.setOnClickListener {
            startActivity(Intent(this, MobilePaymentActivity::class.java))
        }

        transferPayBtn.setOnClickListener {
            startActivity(Intent(this, TransferActivity::class.java))
        }

        communalPayBtn.setOnClickListener {
            startActivity(Intent(this, CommunalPaymentActivity::class.java))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.faq, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.faq_menu_item -> {
                getDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    public fun getDialog() {
        var dialog = Dialog(this,R.style.MyTheme)
        dialog.setContentView(R.layout.info_bank)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams

        val installBankBtn = dialog.install_sberbank
        val closeInfo = dialog.close_dialog_bank_btn

        installBankBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.sberbankmobile")))
        }
        closeInfo.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()


    }
}
