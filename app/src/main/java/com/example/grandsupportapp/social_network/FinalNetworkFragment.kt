package com.example.grandsupportapp.social_network


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
class FinalNetworkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_final_network, container, false)
        val finalBtn = root.findViewById<Button>(R.id.final_transfer_btn)

        finalBtn.setOnClickListener {
            startActivity(Intent(activity!!, MainActivity::class.java))
            onDestroy()
        }
        return root
    }


}
