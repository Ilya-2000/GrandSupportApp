package com.example.grandsupportapp.bank.mobile_payment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.grandsupportapp.R

/**
 * A simple [Fragment] subclass.
 */
class ThirdMobilePaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_third_mobile_payment, container, false)
        return root
    }


}
