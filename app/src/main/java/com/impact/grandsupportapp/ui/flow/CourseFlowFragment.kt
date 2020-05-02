package com.impact.grandsupportapp.ui.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.impact.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class CourseFlowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_flow, container, false)
    }

}
