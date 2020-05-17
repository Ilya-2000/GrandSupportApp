package com.impact.grandsupportapp.ui

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import com.impact.grandsupportapp.database.userDb.UserDao
import com.impact.grandsupportapp.database.userDb.UserDb
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private var dataBase: UserDb? = null
    private var userDao: UserDao? = null
    private var user: User? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_login, container, false)
        dataBase = UserDb.getUserDb(requireContext())

        val emailRegText = root.findViewById<EditText>(R.id.email_reg_text)
        val userNameRegText = root.findViewById<EditText>(R.id.name_reg_text)
        val passRegText = root.findViewById<EditText>(R.id.password_reg_text)
        val pass2RegText = root.findViewById<EditText>(R.id.password2_reg_text)
        val enterRegBtn = root.findViewById<Button>(R.id.enter_reg_btn)

        ///
        val emailLoginText = root.findViewById<EditText>(R.id.email_login_text)
        val passwordLoginText = root.findViewById<EditText>(R.id.password_login_text)
        val enterLoginBtn = root.findViewById<Button>(R.id.enter_login_btn)

        val tabLoginBtn = root.findViewById<Button>(R.id.tab_login_btn)
        val tabRegBtn = root.findViewById<Button>(R.id.tab_reg_btn)
        val loginCard = root.findViewById<CardView>(R.id.login_card_layout)
        val regCard = root.findViewById<CardView>(R.id.registration_card_layout)
        ///
        val navController = findNavController()

        enterLoginBtn.setOnClickListener {
            val email: String = emailLoginText.text.toString()
            val password: String = passwordLoginText.text.toString()

            if (email.length > 4 && email.contains("@") && password.length > 4) {
                var firebaseAuth = FirebaseAuth.getInstance()
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            var currentUser = firebaseAuth.currentUser
                            Log.d("CurrentUser", currentUser!!.uid)
                            getUser(currentUser.uid)
                            //передать user в course и перейти туда

                        }
                    }
            } else {
                Toast.makeText(activity, "Неправильный ввод.", Toast.LENGTH_LONG).show()
            }

        }


         enterRegBtn.setOnClickListener {
             val email: String = emailRegText.text.toString()
             val password: String = passRegText.text.toString()
             val password2: String = pass2RegText.text.toString()
             val name: String = userNameRegText.text.toString()
             val user = User("", name, email, password, 1, 1)
             if (email.length > 4 && email.contains("@") && password == password2 && password.length > 4) {
                 val auth = FirebaseAuth.getInstance()
                     .createUserWithEmailAndPassword(email, password)
                     .addOnCompleteListener {
                         if (it.isSuccessful) {
                             Log.d("ResultReg", it.result.toString())
                            // navController.navigate(R.id.action_loginFragment_to_courseFragment)
                         } else {

                         }
                     }
                     .addOnSuccessListener {
                         Log.d("ResultRegSuccess", it.user!!.uid)
                         var user = User(it.user!!.uid, name, email, password, 0, 1)
                         writeNewUser(user)
                         loginCard.visibility = View.VISIBLE
                         regCard.visibility = View.GONE
                         tabLoginBtn.setTextColor(resources.getColor(R.color.colorAccent))
                         tabRegBtn.setTextColor(Color.WHITE)

                         navController.navigate(R.id.action_loginFragment_to_courseFragment)

                     }
                     .addOnFailureListener {
                         Log.d("ExeptReg", it.message.toString())
                     }
             } else {
                 Toast.makeText(activity, "Неправильный ввод.", Toast.LENGTH_LONG).show()
             }



        }

         tabLoginBtn.setOnClickListener {
             loginCard.visibility = View.VISIBLE
             regCard.visibility = View.GONE
             tabLoginBtn.setTextColor(resources.getColor(R.color.colorAccent))
             tabRegBtn.setTextColor(Color.WHITE)
        }

        tabRegBtn.setOnClickListener {
            loginCard.visibility = View.GONE
            regCard.visibility = View.VISIBLE
            tabRegBtn.setTextColor(resources.getColor(R.color.colorAccent))
            tabLoginBtn.setTextColor(Color.WHITE)
        }
        return root

    }

    fun getUser(uid: String): User? {
        Observable.fromCallable({
            dataBase = UserDb.getUserDb(requireContext())
            userDao = dataBase?.userDao()
            user = userDao?.getUserById(uid)
        })
        return user
    }

   private fun writeNewUser(user: User) {
        Observable.fromCallable({
            dataBase = UserDb.getUserDb(requireContext())
            userDao = dataBase?.userDao()
            userDao?.insert(user)
            var id = user.id
            var user2: User
            user2 = userDao?.getUserById(id)!!
            Log.d("UserFromRoom", user2.id + user2.email)
        }).doOnNext({
            Log.d("MessageInsert", it.toString())
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }
}
