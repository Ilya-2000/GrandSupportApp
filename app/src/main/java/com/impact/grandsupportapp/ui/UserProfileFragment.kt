package com.impact.grandsupportapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User

/**
 * A simple [Fragment] subclass.
 */
class UserProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_user_profile, container, false)
        val nameText = root.findViewById<TextView>(R.id.name_profile_text)
        val emailText = root.findViewById<TextView>(R.id.current_email_profile)
        val passwordText = root.findViewById<TextView>(R.id.current_password_profile)
        val levelText = root.findViewById<TextView>(R.id.current_level_profile)
        val editBtn = root.findViewById<FloatingActionButton>(R.id.edit_profile_fab)
        val backBtn = root.findViewById<ImageButton>(R.id.back_to_course_btn)

        val navController = findNavController()

        var user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
            arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )

        var db = FirebaseFirestore.getInstance()
            .collection("users")
            .document()
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    it.addOnSuccessListener {
                        user = User(it["id"].toString(), it["name"].toString(), it["email"].toString(),
                            it["password"].toString(), it["level"] as Int, it["stage"] as Int)
                    }
                }
            }.addOnFailureListener {

            }


        nameText.text = user.name
        emailText.text = user.email
        passwordText.text = user.password
        levelText.text = user.currentLevel.toString()

        val bundle = Bundle()
        bundle.putString("id",user.id)
        bundle.putString("name",user.name)
        bundle.putString("password", user.password)
        bundle.putString("email", user.email)
        bundle.putInt("level", user.currentLevel)
        bundle.putInt("stage", user.currentStage)

        editBtn.setOnClickListener {
            navController.navigate(R.id.action_userProfileFragment_to_editProfileFragment, bundle)
        }

        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return root
    }

}
