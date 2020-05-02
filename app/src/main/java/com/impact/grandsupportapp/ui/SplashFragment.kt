package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.impact.grandsupportapp.R

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
        //splashWork(navController)
        navController.navigate(R.id.action_splashFragment_to_loginFragment)

        return root
    }

    /* private fun splashWork(navController: NavController) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            navController.navigate(R.id.action_splashFragment_to_loginFragment)


        }, 2000)
    }*/

}
