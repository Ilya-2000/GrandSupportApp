package com.impact.grandsupportapp.mvp.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.data.User


class UserModel {

    //val lessonPresenter: LessonPresenter by
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

     fun LoadLesson() {
        val courseIdList = mutableListOf<String>("course_1", "course_2")


        for (i in 0 until courseIdList.size) {
            FirebaseFirestore.getInstance()
                .collection("courses")
                .document(courseIdList[i])
                .get()
                .addOnSuccessListener {
                    Log.d("LoadedData", it.data.toString())
                    var lesson = Lesson(it["id"] as Int, it["name"].toString(),it["courseName"].toString(), it["steps"] as Int)

                }
                .addOnFailureListener {
                    Log.d("LoadedData", it.message.toString())
                }
        }
    }



}
