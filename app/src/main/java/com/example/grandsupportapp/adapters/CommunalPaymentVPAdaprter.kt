package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.bank.communal_payment.*
import com.example.grandsupportapp.bank.mobile_payment.*

class CommunalPaymentVPAdaprter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 11
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FirstCommunalFragment()
            1 -> fragment = SecondCommunalFragment()
            2 -> fragment = ThirdCommunalFragment()
            3 -> fragment = FourCommunalFragment()
            4 -> fragment = FiveCommunalFragment()
            5 -> fragment = SixCommunalFragment()
            6 -> fragment = SevenCommunalFragment()
            7 -> fragment = EightCommunalFragment()
            8 -> fragment = NineCommunalFragment()
            9 -> fragment = TenCommunalFragment()
            10 -> fragment = ElevenCommunalFragment()

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
            6 -> t = "7 шаг"
            7 -> t = "8 шаг"
            8 -> t = "9 шаг"
            9 -> t = "10 шаг"
            10 -> t = "Завершение"


        }
        return t
    }


}