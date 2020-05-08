package com.impact.grandsupportapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.impact.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class LessonListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_list, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.lesson_list_rv)
        return root
    }

}
