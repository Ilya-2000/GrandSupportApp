package com.impact.grandsupportapp.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.impact.grandsupportapp.R
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_splash, container, false)
        val navController = findNavController()
            splashWork(navController)


        return root
    }
      fun splashWork(navController: NavController) {
          val activity = MainActivity()

          var shared = this.requireActivity().getSharedPreferences("fstart", Context.MODE_PRIVATE)
          var isVisited: Boolean = shared.getBoolean("visited", false)
          if (!isVisited) {
              var editor = shared.edit()
              editor.putBoolean("visited", true)
              editor.apply()
              val handler = Handler().postDelayed(Runnable {
                  navController.navigate(R.id.action_splashFragment_to_loginFragment)
              }, 2000)

          } else {
              navController.navigate(R.id.action_splashFragment_to_loginFragment)
          }

    }

    /*fun isConnection(context: Context): Boolean {
        var connectivityManager: ConnectivityManager =
    }*/

}
