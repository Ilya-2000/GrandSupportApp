package com.example.grandsupportapp.smartphone.basic_management


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class SecondManagementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_second_management, container, false)
        val nextBtn = root.findViewById<Button>(R.id.next_management_fragment_btn)

        nextBtn.setOnClickListener {
            startActivity(Intent(activity!!, ThirdManagementActivity::class.java))
            onDestroy()

        }
        return root
    }


}
