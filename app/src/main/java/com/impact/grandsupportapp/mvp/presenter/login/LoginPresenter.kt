package com.impact.grandsupportapp.mvp.presenter.login

import android.app.Activity
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import com.impact.grandsupportapp.mvp.model.UserModel
import com.impact.grandsupportapp.mvp.presenter.lesson.LessonPresenter
import com.impact.grandsupportapp.ui.LoginFragment
import com.impact.grandsupportapp.ui.MainActivity
import kotlin.coroutines.CoroutineContext

class LoginPresenter : LoginContract.Presenter, LoginContract.OnLoginListener, LoginContract.View {
    val model: UserModel = UserModel()
    override fun getResultLogin(): Boolean {
        return true
    }

    override fun OnSuccess(): Boolean {
        var b: Boolean = true
        return b
    }

    override fun OnFailure(): Boolean {
        return true
    }

    override fun getAuthMessage(): Int {
        return R.string.auth_fail
    }


    override fun FireBaseLogin(user: User, activity: Activity, navController: NavController){
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(activity) {
                    if (it.isSuccessful) {
                        LoadScreen(navController, R.id.action_loginFragment_to_courseFragment)
                        Log.d("Result", it.result.toString())
                    }
            }
            .addOnFailureListener {
                Log.d("BadResult", it.message.toString())
                getAuthMessage()
            }
    }

    override fun FireBaseRegistration(user: User, navController: NavController) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user.email, user.password)
            .addOnSuccessListener {
                val userId = it.user
                user.id = userId.toString()
                model.WriteNewUser(user)
                LoadScreen(navController, R.id.action_loginFragment_to_courseFragment)
            }
            .addOnFailureListener {
                getAuthMessage()
            }

    }



    override fun ShowInputCaution(): Int {
        return R.string.error_input_login
    }

    override fun ShowEmptyInputCaution(): Int {
        return R.string.error_empty_login
    }

    override fun chooseView(btnSelected: Int, loginCard: CardView, regCard: CardView) {
        if (btnSelected == (R.id.tab_login_btn)) {
            loginCard.visibility = View.VISIBLE
            regCard.visibility = View.GONE

        } else {
            regCard.visibility = View.VISIBLE
            loginCard.visibility = View.GONE
        }
    }



    override fun CheckFillLoginData(user: User): Boolean {
        var boolean: Boolean
        if (user.email.isNotEmpty() && user.password.isNotEmpty()) {
            boolean = true
        } else {
            boolean = false
        }
        return boolean

    }


    override fun CheckContentLoginData(user: User): Boolean {
        var boolean: Boolean
        if (user.email.length > 4 && user.email.contains("@") && user.password.length > 4) {
            boolean = true
        } else {
            boolean = false
        }
        return boolean
    }

    override fun CheckFillRegistrationData(user: User): Boolean {
        var boolean: Boolean
        if(user.name.isNotBlank() && user.email.isNotBlank() && user.password.isNotBlank()){
            boolean = true
        } else {
            boolean = false
        }
        return boolean

    }

    override fun CheckContentRegistrationData(user: User): Boolean {
        return (user.name.length > 1 && user.email.length > 4 && user.password.length > 4 && user.email.contains("@"))
    }

    override fun LoadLessonData(activity: MainActivity) {
        model.LoadLesson(activity)
    }

    override fun LoadScreen(navController: NavController, id: Int) {
        navController.navigate(id)
    }
}