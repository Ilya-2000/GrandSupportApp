package com.example.grandsupportapp.smartphone.tools_learn


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
import com.example.grandsupportapp.smartphone.SmartphoneActivity
import kotlinx.android.synthetic.main.full_img.*

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
