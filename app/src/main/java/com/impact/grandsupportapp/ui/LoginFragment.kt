package com.impact.grandsupportapp.ui

import android.app.Activity
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
import com.impact.grandsupportapp.mvp.model.UserModel
import com.impact.grandsupportapp.mvp.presenter.login.LoginContract
import com.impact.grandsupportapp.mvp.presenter.login.LoginPresenter
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment(), LoginContract {
    val loginPresenter: LoginPresenter = LoginPresenter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_login, container, false)

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
            //var bb: Int? = null
            val email: String = emailLoginText.text.toString()
            val password: String = passwordLoginText.text.toString()
            val user = User("","", email, password, 0)
            val a = loginPresenter.CheckContentLoginData(user)
            val b = loginPresenter.CheckFillLoginData(user)
            if (a && b) {
                loginPresenter.FireBaseLogin(user, this.requireActivity(), navController)
                } else {
                Toast.makeText(activity,loginPresenter.ShowEmptyInputCaution(), Toast.LENGTH_LONG).show()
                //bb = 0
            }

        }


         enterRegBtn.setOnClickListener {

            val email: String = emailRegText.text.toString()
            val password: String = passRegText.text.toString()
            val password2: String = pass2RegText.text.toString()
            val name: String = userNameRegText.text.toString()
            val user = User("", name, email, password, 1)
            val a = loginPresenter.CheckContentRegistrationData(user)
            val b = loginPresenter.CheckFillRegistrationData(user)

            if (a && b && password == password2) {
                loginPresenter.FireBaseRegistration(user, navController)
            } else {
                if (!a) {
                    Toast.makeText(activity, loginPresenter.ShowEmptyInputCaution(), Toast.LENGTH_LONG).show()
                } else if (!b) {
                    Toast.makeText(activity, loginPresenter.ShowInputCaution(), Toast.LENGTH_LONG).show()
                }
            }
                navController.navigate(R.id.action_loginFragment_to_courseFragment)

                Toast.makeText(activity, loginPresenter.getAuthMessage(), Toast.LENGTH_LONG).show()


        }

         tabLoginBtn.setOnClickListener {
            loginPresenter.chooseView(R.id.tab_login_btn, loginCard, regCard)
        }

        tabRegBtn.setOnClickListener {
            loginPresenter.chooseView(R.id.tab_reg_btn, loginCard, regCard)
        }
        return root

    }
}
