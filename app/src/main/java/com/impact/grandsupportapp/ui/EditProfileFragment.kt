package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import kotlinx.coroutines.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [EditProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditProfileFragment : Fragment() {
    private var currentEmail: String? = null
    private var currentPassword: String? = null
    private var newPass: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        val nameText = root.findViewById<TextView>(R.id.edit_name_profile_text)
        val emailText = root.findViewById<TextView>(R.id.edit_email_profile)
        val passwordText = root.findViewById<TextView>(R.id.edit_password_profile)
        val levelText = root.findViewById<TextView>(R.id.edit_level_profile)
        val acceptBtn = root.findViewById<FloatingActionButton>(R.id.accept_profile_fab)
        val backBtn = root.findViewById<ImageButton>(R.id.back_to_profile_btn)

        var user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
            arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )
        currentEmail = user.email
        currentPassword = user.password

        nameText.text = user.name
        emailText.text = user.email
        passwordText.text = user.password
        levelText.text = user.currentLevel.toString()

        val navController = findNavController()

        acceptBtn.setOnClickListener {
            user.name = nameText.text.toString()
            user.password = passwordText.text.toString()
            newPass = passwordText.text.toString()
            dataProcess(user)
            requireActivity().onBackPressed()
        }
        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return root
    }

    fun dataProcess(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            async {
                writeData(user)
                delay(1000)
            }.await()

        }

    }

    suspend fun writeData(user: User) {
        var firebaseFirestore = FirebaseFirestore.getInstance()
            .collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("InsertFBProfile", it.id)
            }
            .addOnFailureListener {
                Log.d("InsertFBProfile", it.message.toString())
            }

        var firebaseAuth = FirebaseAuth.getInstance().currentUser
        val authCredential = EmailAuthProvider.getCredential(currentEmail!!, currentPassword!!)
        firebaseAuth?.reauthenticate(authCredential)
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    firebaseAuth.updatePassword(this.newPass.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Log.d("PasswordUpdate", "Success")
                        }
                    }
                }
            }

    }

}