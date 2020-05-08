package com.impact.grandsupportapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.impact.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class LessonPlaceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_place, container, false)
        val viewPager = root.findViewById<ViewPager>(R.id.lesson_vp)
        return root
    }

}

