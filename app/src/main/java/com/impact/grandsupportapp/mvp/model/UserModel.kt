package com.impact.grandsupportapp.mvp.model

import android.util.Log
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User


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

    fun clearUserData(user: User) {

    }



}
