package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.adapter.LessonListRvAdapter
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.data.User

/**
 * A simple [Fragment] subclass.
 */
class LessonListFragment : Fragment() {
    var lessonList: MutableList<Lesson>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_list, container, false)
        val navController = findNavController()
        val recyclerView = root.findViewById<RecyclerView>(R.id.lesson_list_rv)
        var courseNumber = arguments?.get("courseNumber")!! as Int
        Log.d("CourseNumber", courseNumber.toString())
        //
        var user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
            arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )
        lessonList = arguments?.getParcelableArrayList("lessonList")
        Log.d("LessonInLessonList", lessonList?.size.toString())

        val adapter = LessonListRvAdapter(requireContext(), lessonList!!, navController)
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        recyclerView.adapter = adapter

        return root
    }

}
