package com.impact.grandsupportapp.mvp.model

import android.util.Log
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import io.reactivex.Observable


class UserModel {

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
                }
                .addOnFailureListener {
                    Log.d("LoadedData", it.message.toString())
                }
        }
    }



}
