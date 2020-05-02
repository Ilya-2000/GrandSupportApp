package com.impact.grandsupportapp.mvp.presenter.login

import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import com.impact.grandsupportapp.ui.LoginFragment

class LoginPresenter : LoginContract.Presenter, LoginContract.OnLoginListener, LoginContract.View {
    override fun OnSuccess(): Boolean {
        return true
    }

    override fun OnFailure(): Boolean {
        return false
    }

    override fun getAuthMessage(): Int {
        return R.string.auth_fail
    }


    override fun FireBaseLogin(user: User) {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    OnSuccess()

                }
            }
            .addOnFailureListener {
                OnFailure()
                getAuthMessage()
            }
    }

    override fun FireBaseRegistration(user: User) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener {
                val userId = it.result?.user
                WriteNewUser(userId!!, user)
                OnSuccess()
            }
            .addOnFailureListener {

            }
    }

    override fun WriteNewUser(userId: FirebaseUser, user: User) {
        val userMap = mapOf<String, Any>("userId" to userId, "user" to user)
        FirebaseFirestore.getInstance()
            .collection("users")
            .add(userMap)
            .addOnCompleteListener {
                Log.d("reg", it.result.toString())
            }
            .addOnFailureListener {
                exception ->
                Log.d("reg", exception.message.toString())
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
        return user.email.isNotEmpty() && user.password.isNotEmpty()
    }


    override fun CheckContentLoginData(user: User): Boolean {
        return user.email.length > 4 && user.email.contains("@") && user.password.length > 4
    }

    override fun CheckFillRegistrationData(user: User): Boolean {
       return (user.name.isNotBlank() && user.email.isNotBlank() && user.password.isNotBlank())
    }

    override fun CheckContentRegistrationData(user: User): Boolean {
        return (user.name.length > 1 && user.email.length > 4 && user.password.length > 4 && user.email.contains("@"))
    }
}