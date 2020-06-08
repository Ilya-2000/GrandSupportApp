package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.adapter.LessonListRvAdapter
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.data.PreUser
import com.impact.grandsupportapp.data.User
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass.
 */
class LessonListFragment : Fragment() {
    var lessonList: MutableList<Lesson>? = null
    private var user: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_list, container, false)

        user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
            arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )

        getUserGlobal(user?.email!!)
        val navController = findNavController()
        val recyclerView = root.findViewById<RecyclerView>(R.id.lesson_list_rv)
        var courseNumber = arguments?.get("courseNumber")!! as Int
        val backBtn = root.findViewById<ImageButton>(R.id.back_to_course_lesson_list)
        Log.d("CourseNumber", courseNumber.toString())

        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        //

        lessonList = arguments?.getParcelableArrayList("lessonList")
        Log.d("LessonInLessonList", lessonList?.size.toString())

        val adapter = LessonListRvAdapter(requireContext(), lessonList!!, navController)
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        recyclerView.adapter = adapter

        return root
    }


    fun getUserGlobal(email: String) {
        CoroutineScope(Dispatchers.IO).launch {
            async {
                getUser(email)
                delay(1000)
            }.await()
        }
    }

    suspend fun getUser(email: String) {
        val userFirestore = FirebaseFirestore.getInstance()
            .collection("users")
            .document(email)
            .get()
            .addOnSuccessListener {

                var preUser = PreUser(
                    it["id"].toString(),
                    it["name"].toString(),
                    it["email"].toString(),
                    it["password"].toString(),
                    it["level"].toString(),
                    it["stage"].toString())


                user = User(
                    preUser.id,
                    preUser.name,
                    preUser.email,
                    preUser.password,
                    preUser.currentLevel.toInt(),
                    preUser.currentStage.toInt()
                )
                Log.d("UserInCourseLoaded", user?.name.toString())
            }
    }

}
