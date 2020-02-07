package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.bank.mobile_payment.*
import com.example.grandsupportapp.registration_steps.*

class MobilePaymentVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 7
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartMobilePaymentFragment()
            1 -> fragment = FirstMobilePaymentFragment()
            2 -> fragment = SecondMobilePaymentFragment()
            3 -> fragment = ThirdMobilePaymentFragment()
            4 -> fragment = FourMobilePaymentFragment()
            5 -> fragment = FiveMobilePaymentFragment()
            6 -> fragment = FinallyMobilePaymentFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }


}