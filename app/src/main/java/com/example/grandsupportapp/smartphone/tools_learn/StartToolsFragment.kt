package com.example.grandsupportapp.smartphone.tools_learn


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class StartToolsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_tools, container, false)
    }


}
