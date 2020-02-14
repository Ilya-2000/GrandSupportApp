package com.example.grandsupportapp.smartphone.settings_learn


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
class FinalSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_final_settings, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_settings_btn)

        finalBtn.setOnClickListener {
            startActivity(Intent(activity!!, SmartphoneActivity::class.java))
        }
        return root
    }


}
