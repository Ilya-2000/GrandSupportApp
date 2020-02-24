package com.impact.grandsupportapp.smartphone.tools_learn


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.smartphone.SmartphoneActivity

/**
 * A simple [Fragment] subclass.
 */
class FiveteenToolsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_fiveteen_tools, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_tools_btn)
        finalBtn.setOnClickListener {
            startActivity(Intent(activity!!, SmartphoneActivity::class.java))
            onDestroy()
        }
        return root
    }



}
