package com.impact.grandsupportapp.mvp.presenter.login

import android.view.View
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseUser
import com.impact.grandsupportapp.data.User

interface LoginContract {
    interface View {
        fun ShowInputCaution(): Int
        fun ShowEmptyInputCaution(): Int
        fun chooseView(btnSelected: Int, loginCard: CardView, regCard: CardView)
    }

    interface Presenter {
        fun FireBaseLogin(user: User)
        fun FireBaseRegistration(user: User)
        fun WriteNewUser(userId: FirebaseUser, user: User)
        fun CheckFillLoginData(user: User): Boolean
        fun CheckContentLoginData(user: User): Boolean
        fun CheckFillRegistrationData(user: User): Boolean
        fun CheckContentRegistrationData(user: User): Boolean

    }

    interface OnLoginListener {
        fun OnSuccess(): Boolean
        fun OnFailure(): Boolean
        fun getAuthMessage(): Int
    }

    interface OnRegistrationListener {
        fun OnSuccess(): Boolean
        fun OnFailure(): Boolean
    }

}