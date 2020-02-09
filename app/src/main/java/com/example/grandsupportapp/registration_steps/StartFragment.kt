package com.example.grandsupportapp.registration_steps


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.grandsupportapp.FullscreenImageActivity

import com.example.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_start, container, false)
        val img = root.findViewById<ImageView>(R.id.img_fragment)

        img.setOnClickListener {
           var intent = Intent(context, FullscreenImageActivity::class.java)
            intent.putExtra("img", img.drawable.toString())
            startActivity(intent)
        }
        return root
    }


}
