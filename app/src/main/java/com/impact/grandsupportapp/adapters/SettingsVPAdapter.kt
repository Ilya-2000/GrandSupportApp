package com.impact.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.impact.grandsupportapp.smartphone.settings_learn.*

class SettingsVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 9
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartSettingsFragment()
            1 -> fragment = FirstSettingsFragment()
            2 -> fragment = SecondSettingsFragment()
            3 -> fragment = ThirdSettingsFragment()
            4 -> fragment = FourSettingsFragment()
            5 -> fragment = FiveSettingsFragment()
            6 -> fragment = SixSettingsFragment()
            7 -> fragment = SevenSettingsFragment()
            8 -> fragment = FinalSettingsFragment()


        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var t: String? = null
        when (position) {
            0 -> t = "Знакомство"
            1 -> t = "1 шаг"
            2 -> t = "2 шаг"
            3 -> t = "3 шаг"
            4 -> t = "4 шаг"
            5 -> t = "5 шаг"
            6 -> t = "6 шаг"
            7 -> t = "7 шаг"
            8 -> t = "Завершение"



        }
        return t
    }


}