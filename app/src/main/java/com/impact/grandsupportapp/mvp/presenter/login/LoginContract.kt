package com.impact.grandsupportapp.mvp.presenter.login

import android.app.Activity
import android.view.View
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.impact.grandsupportapp.data.User

interface LoginContract {
    interface View {
        fun ShowInputCaution(): Int
        fun ShowEmptyInputCaution(): Int
        fun chooseView(btnSelected: Int, loginCard: CardView, regCard: CardView)
    }

    interface Presenter {
        fun FireBaseLogin(user: User, activity: Activity, navController: NavController)
        fun FireBaseRegistration(user: User, navController: NavController)
        fun CheckFillLoginData(user: User): Boolean
        fun CheckContentLoginData(user: User): Boolean
        fun CheckFillRegistrationData(user: User): Boolean
        fun CheckContentRegistrationData(user: User): Boolean
        fun LoadLessonData()
        fun LoadScreen(navController: NavController, id: Int)



    }

    interface OnLoginListener {
        fun getResultLogin(): Boolean
        fun OnSuccess(): Boolean
        fun OnFailure(): Boolean
        fun getAuthMessage(): Int
    }

    interface OnRegistrationListener {
        fun OnSuccess(): Boolean
        fun OnFailure(): Boolean
    }

}