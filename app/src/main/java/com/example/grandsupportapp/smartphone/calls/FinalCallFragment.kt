package com.example.grandsupportapp.smartphone.calls


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.grandsupportapp.R
import com.example.grandsupportapp.smartphone.SmartphoneActivity

/**
 * A simple [Fragment] subclass.
 */
class FinalCallFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_final_call, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_call_btn)
        finalBtn.setOnClickListener {
            startActivity(Intent(activity!!, SmartphoneActivity::class.java))
            onDestroy()
        }
        return root
    }


}
