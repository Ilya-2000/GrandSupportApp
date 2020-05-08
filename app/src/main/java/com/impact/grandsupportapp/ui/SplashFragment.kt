package com.impact.grandsupportapp.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.mvp.presenter.lesson.LessonPresenter
import com.impact.grandsupportapp.mvp.presenter.login.LoginPresenter

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {
    var loginPresenter = LoginPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        val navController = findNavController()
        val handler = Handler()
        handler.postDelayed(Runnable {
            splashWork(navController)
        }, 200)

        return root
    }
      fun splashWork(navController: NavController) {
          var shared = this.requireActivity().getSharedPreferences("fstart", Context.MODE_PRIVATE)
          var isVisited: Boolean = shared.getBoolean("visited", false)
          if (!isVisited) {
              var editor = shared.edit()
              editor.putBoolean("visited", true)
              editor.apply()
              loginPresenter.LoadLessonData()
              val handler = Handler().postDelayed(Runnable {
                  navController.navigate(R.id.action_splashFragment_to_loginFragment)
              }, 5000)

          } else {
              navController.navigate(R.id.action_splashFragment_to_loginFragment)
          }

    }

}
