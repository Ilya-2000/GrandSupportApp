package com.example.grandsupportapp.bank.money_transfer


import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView

import com.example.grandsupportapp.R
import com.example.grandsupportapp.bank.BankMainActivity
import kotlinx.android.synthetic.main.full_img.*

/**
 * A simple [Fragment] subclass.
 */
class FinalTransferFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_final_transfer, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_transfer_btn)

        finalBtn.setOnClickListener {
            startActivity(Intent(activity, BankMainActivity::class.java))
        }
        return root
    }


}
