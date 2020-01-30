package com.example.grandsupportapp.registration_steps


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.grandsupportapp.MainActivity

import com.example.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class FinallyRegFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_finally_reg, container, false)
        val finalBtn = root.findViewById<Button>(R.id.finally_reg_btn)
        finalBtn.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }
        return root
    }


}
