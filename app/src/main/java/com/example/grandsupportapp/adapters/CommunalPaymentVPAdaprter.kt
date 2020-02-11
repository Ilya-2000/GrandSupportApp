package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.bank.mobile_payment.*

class CommunalPaymentVPAdaprter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 7
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
           /* 0 -> fragment = StartMobilePaymentFragment()
            1 -> fragment = FirstMobilePaymentFragment()
            2 -> fragment = SecondMobilePaymentFragment()
            3 -> fragment = ThirdMobilePaymentFragment()
            4 -> fragment = FourMobilePaymentFragment()
            5 -> fragment = FiveMobilePaymentFragment()
            6 -> fragment = FinallyMobilePaymentFragment()*/
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var t: String? = null
        when (position) {
            0 -> t = "1 шаг"
            1 -> t = "2 шаг"
            2 -> t = "3 шаг"
            3 -> t = "4 шаг"
            4 -> t = "5 шаг"
            5 -> t = "6 шаг"
            6 -> t = "Завершение"


        }
        return t
    }


}