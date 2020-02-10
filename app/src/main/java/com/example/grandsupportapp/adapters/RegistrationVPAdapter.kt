package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.registration_steps.*

class RegistrationVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 12
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartFragment()
            1 -> fragment = SecondRegFragment()
            2 -> fragment = ThirdRegFragment()
            3 -> fragment = FourRegFragment()
            4 -> fragment = FiveRegFragment()
            5 -> fragment = SixRegFragment()
            6 -> fragment = SevenRegFragment()
            7 -> fragment = EigthFragment()
            8 -> fragment = NineRegFragment()
            9 -> fragment = TenRegFragment()
            10 -> fragment = ElevenRegFragment()
            11 -> fragment = FinallyRegFragment()
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
            10 -> t = "11 шаг"
            11 -> t = "Завершение"


        }
        return t
    }
}