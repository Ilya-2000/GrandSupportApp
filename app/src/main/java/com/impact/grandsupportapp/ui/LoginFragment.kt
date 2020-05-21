package com.impact.grandsupportapp.ui

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

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
    private var userList: MutableList<User>? = null
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
                            val currentUser = firebaseAuth.currentUser
                            Log.d("CurrentUser", currentUser!!.uid)
                            //var user = getUser(currentUser.uid.toString(), this.requireContext())
                            var user1: User
                            Observable.fromCallable {
                                dataBase = UserDb.getUserDb(this.requireContext())
                                userDao = dataBase?.userDao()
                                user1 = userDao?.getUserById(currentUser.uid)!!
                                var user2 = User(user1.id, user1.name, user1.email, user1.password, user1.currentLevel, user1.currentStage)
                                if (user1 != null) {
                                    Log.d("UserFromRoom", user1.email + " " + user1.id)
                                    user = User(user2.id, user2.name, user2.email, user2.password, user2.currentLevel, user2.currentStage)

                                } else {
                                    val firebaseFirestore = FirebaseFirestore.getInstance()
                                        .collection("users")
                                        .document(email)
                                        .get()
                                        .addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Log.d("LoadFromFirebase", it.result.toString())
                                                it.addOnSuccessListener {
                                                    user = User(it["id"].toString(), it["name"].toString(), it["email"].toString(),
                                                        it["password"].toString(), it["level"] as Int, it["stage"] as Int)
                                                }
                                            } else {
                                                Log.d("LoadFromFirebase", it.exception.toString())
                                            }
                                        }
                                    Log.d("UserFromRoom", "Null")
                                }
                                //Log.d("UserFromRoom", user?.email + " " + user?.id)
                            }.doOnNext {
                                Log.d("MessageInsert", it.toString())
                            }.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe()

                            val handler = Handler().postDelayed(Runnable {
                                val bundle = Bundle()
                                bundle.putString("id",user?.id)
                                bundle.putString("name",user?.name)
                                bundle.putString("password", user?.password)
                                bundle.putString("email", user?.email)
                                bundle.putInt("level", user?.currentLevel!!)
                                bundle.putInt("stage", user?.currentStage!!)
                                Log.d("UserIsReady", user?.name.toString())
                                navController.navigate(R.id.action_loginFragment_to_courseFragment, bundle)
                            }, 1000)

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
                         var user = User(it.user!!.uid.toString(), name, email, password, 1, 0)
                         writeNewUser(user, this.requireContext())
                         loginCard.visibility = View.VISIBLE
                         regCard.visibility = View.GONE
                         tabLoginBtn.setTextColor(resources.getColor(R.color.colorAccent))
                         tabRegBtn.setTextColor(Color.WHITE)

                         //navController.navigate(R.id.action_loginFragment_to_courseFragment)

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

    private fun getUser(uid: String, context: Context, email: String): User? {
        var user1: User


        Observable.fromCallable {
            dataBase = UserDb.getUserDb(context)
            userDao = dataBase?.userDao()
            user1 = userDao?.getUserById(uid)!!
            var user2 = User(user1.id, user1.name, user1.email, user1.password, user1.currentLevel, user1.currentStage)
            //user1.id = ""
            if (user1.id.isNotEmpty()) {
                Log.d("UserFromRoom", user1.email + " " + user1.id)
                user = User(user2.id, user2.name, user2.email, user2.password, user2.currentLevel, user2.currentStage)
            } else {
                Log.d("UserFromRoom", "Null")


            }
            //Log.d("UserFromRoom", user?.email + " " + user?.id)
        }.doOnNext {
                Log.d("MessageInsert", it.toString())
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        return user
    }

   private fun writeNewUser(user: User, context: Context) {
        Observable.fromCallable {
            dataBase = UserDb.getUserDb(context)
            userDao = dataBase?.userDao()
            userDao?.insert(user)
            var id = user.id
            var user2: User
            user2 = userDao?.getUserById(id)!!
            Log.d("UserFromRoom", user2.id + user2.email)
        }.doOnNext {
            Log.d("MessageInsert", it.toString())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        var userMap = hashMapOf<String, Any>(
            "id" to user.id,
            "name" to user.name,
            "email" to user.email,
            "password" to user.password,
            "level" to user.currentLevel,
            "stage" to user.currentStage)
        val fs = FirebaseFirestore.getInstance()
            .collection("users")
            .document(user.email)
            .set(userMap)
            .addOnSuccessListener {
                Log.d("WriteInFirebase", "Success")
            }
            .addOnFailureListener {
                Log.d("WriteInFirebase", it.message.toString())
            }
    }
}
