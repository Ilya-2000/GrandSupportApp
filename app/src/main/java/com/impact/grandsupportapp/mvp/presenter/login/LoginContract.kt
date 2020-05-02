package com.impact.grandsupportapp.mvp.presenter.login

import android.view.View
import androidx.cardview.widget.CardView

interface LoginContract {
    interface View {
        fun ShowInputCaution(): Int
        fun ShowEmptyInputCaution(): Int
        fun chooseView(btnSelected: Int, loginCard: CardView, regCard: CardView)
    }

    interface Presenter {
        fun FireBaseLogin(email: String, password: String)
        fun FireBaseRegistration(email: String, password: String, name: String)
        fun WriteNewUser(name: String, email: String, password: String)

    }

    interface OnLoginListener {
        fun OnSuccess(message: String)
        fun OnFailure(message: String)
    }

    interface OnRegistrationListener {
        fun OnSuccess(message: String)
        fun OnFailure(message: String)
    }

}