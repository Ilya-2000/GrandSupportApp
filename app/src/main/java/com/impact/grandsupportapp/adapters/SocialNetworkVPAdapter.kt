package com.impact.grandsupportapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.impact.grandsupportapp.social_network.*

class SocialNetworkVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 13
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = StartNetworkFragment()
            1 -> fragment = FirstNetworkFragment()
            2 -> fragment = SecondNetworkFragment()
            3 -> fragment = ThirdNetworkFragment()
            4 -> fragment = FourNetworkFragment()
            5 -> fragment = FiveNetworkFragment()
            6 -> fragment = SixNetworkFragment()
            7 -> fragment = SevenNetworkFragment()
            8 -> fragment = EightNetworkFragment()
            9 -> fragment = NineNetworkFragment()
            10 -> fragment = TenNetworkFragment()
            11 -> fragment = ElevenNetworkFragment()
            12 -> fragment = FinalNetworkFragment()


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
            12 -> t = "Завершение"


        }
        return t
    }


}