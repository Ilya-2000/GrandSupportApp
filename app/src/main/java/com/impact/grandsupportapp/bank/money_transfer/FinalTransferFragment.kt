package com.impact.grandsupportapp.bank.money_transfer


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.bank.BankMainActivity

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
            onDestroy()
        }
        return root
    }


}
