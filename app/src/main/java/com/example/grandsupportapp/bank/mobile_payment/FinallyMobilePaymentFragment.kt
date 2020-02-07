package com.example.grandsupportapp.bank.mobile_payment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.grandsupportapp.R
import com.example.grandsupportapp.bank.BankMainActivity

/**
 * A simple [Fragment] subclass.
 */
class FinallyMobilePaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_finally_mobile_payment, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_mob_payment_btn)
        finalBtn.setOnClickListener {
            startActivity(Intent(activity, BankMainActivity::class.java))
        }
        return root
    }


}
