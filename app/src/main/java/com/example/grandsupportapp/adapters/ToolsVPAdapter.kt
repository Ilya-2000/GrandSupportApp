package com.example.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.smartphone.settings_learn.*
import com.example.grandsupportapp.smartphone.tools_learn.*

class ToolsVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 16
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartToolsFragment()
            1 -> fragment = FirstToolsFragment()
            2 -> fragment = SecondToolsFragment()
            3 -> fragment = ThirdToolsFragment()
            4 -> fragment = FourToolsFragment()
            5 -> fragment = FiveToolsFragment()
            6 -> fragment = SixToolsFragment()
            7 -> fragment = SevenToolsFragment()
            8 -> fragment = EightToolsFragment()
            9 -> fragment = NineToolsFragment()
            10 -> fragment = TenToolsFragment()
            11 -> fragment = ElevenToolsFragment()
            12 -> fragment = TwelveToolsFragment()
            13 -> fragment = ThirtheenToolsFragment()
            14 -> fragment = FourteenToolsFragment()
            15 -> fragment = FiveteenToolsFragment()


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
            8 -> t = "8 шаг"
            9 -> t = "9 шаг"
            10 -> t = "10 шаг"
            11 -> t = "11 шаг"
            12 -> t = "12 шаг"
            13 -> t = "13 шаг"
            14 -> t = "14 шаг"
            15 -> t = "Завершение"




        }
        return t
    }


}