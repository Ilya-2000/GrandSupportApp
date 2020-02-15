package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.bank.communal_payment.*
import com.example.grandsupportapp.registration_steps.StartFragment
import com.example.grandsupportapp.smartphone.calls.*

class CallVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 12
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartCallFragment()
            1 -> fragment = FirstCallFragment()
            2 -> fragment = SecondCallFragment()
            3 -> fragment = ThirdCallFragment()
            4 -> fragment = FourCallFragment()
            5 -> fragment = FiveCallFragment()
            6 -> fragment = SixCallFragment()
            7 -> fragment = SevenCallFragment()
            8 -> fragment = EightCallFragment()
            9 -> fragment = NineCallFragment()
            10 -> fragment = TenCallFragment()
            11 -> fragment = FinalCallFragment()

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
            10 -> t = "шаг 11"
            10 -> t = "Завершение"


        }
        return t
    }


}