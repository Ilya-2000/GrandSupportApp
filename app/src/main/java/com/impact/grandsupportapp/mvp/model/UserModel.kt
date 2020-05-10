package com.impact.grandsupportapp.mvp.model

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.data.Course
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.data.User
import com.impact.grandsupportapp.database.lessonDb.LessonDao
import com.impact.grandsupportapp.database.lessonDb.LessonViewModel
import com.impact.grandsupportapp.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class UserModel {
    private lateinit var lessonViewModel: LessonViewModel

    fun WriteNewUser(user: User) {
        FirebaseFirestore.getInstance()
            .collection("users")
            .add(user)
            .addOnCompleteListener {
                Log.d("reg", it.result.toString())
                if(it.isSuccessful) {

                }
            }
            .addOnFailureListener {
                    exception ->
                Log.d("reg", exception.message.toString())

            }
    }

    fun ClearUserData(user: User) {

    }

     fun LoadLesson(activity: MainActivity) {
         val courseIdList = mutableListOf<String>("course_1", "course_2")
         lessonViewModel = ViewModelProvider(activity).get(LessonViewModel::class.java)



        for (i in 0 until courseIdList.size) {
            FirebaseFirestore.getInstance()
                .collection("courses")
                .document(courseIdList[i])
                .get()
                .addOnSuccessListener {
                    Log.d("LoadedData", it.data.toString())
                    var course = Course(it["name"] as String, it["id"] as Int, it["level"] as Int,
                        it["lesson_id"] as MutableList<Int>, it["lesson_list"] as MutableList<HashMap<String, Any>>)
                    var lessonMap = HashMap<String, Any>()
                    for (j in  course.lessonsList) {
                        val lesson = Lesson(j["lesson_id"] as Int, j["name"] as String, j["course_name"] as String,
                        j["steps"] as Int, j["text_list"] as MutableList<String>, j["image_list"] as MutableList<String>)
                            lessonViewModel.populateDatabase(lesson)
                            Log.d("LessonLoadData", lesson.name)

                    }


                }
                .addOnFailureListener {
                    Log.d("LoadedData", it.message.toString())
                }
        }
    }

    fun LessonFromCourse(course: Course) {

    }



}
