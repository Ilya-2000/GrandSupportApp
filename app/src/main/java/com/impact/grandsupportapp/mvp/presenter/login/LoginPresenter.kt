package com.impact.grandsupportapp.mvp.presenter.login

import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.User
import com.impact.grandsupportapp.ui.LoginFragment

class LoginPresenter : LoginContract.Presenter, LoginContract.OnLoginListener, LoginContract.View {
    override fun OnSuccess(message: String) {
        Log.d("auth", message)
    }

    override fun OnFailure(message: String) {
        Log.d("auth", message)
    }

    override fun FireBaseLogin(email: String, password: String) {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    OnSuccess(it.result.toString())

                }
            }
            .addOnFailureListener {
                OnFailure(it.message.toString())
            }
    }

    override fun FireBaseRegistration(email: String, password: String, name: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                WriteNewUser(name, email, password)
            }
            .addOnFailureListener {

            }
    }

    override fun WriteNewUser(name: String, email: String, password: String) {
        val user = User(name, email, password)
        FirebaseFirestore.getInstance()
            .collection("users")
            .add(user)
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


}