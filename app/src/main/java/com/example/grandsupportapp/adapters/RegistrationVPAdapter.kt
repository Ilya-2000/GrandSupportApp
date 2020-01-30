package com.example.grandsupportapp.adapters

import android.app.FragmentManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.grandsupportapp.registration_steps.*

class RegistrationVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 12
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FirstRegFragment()
            1 -> fragment = SecondRegFragment()
            2 -> fragment = ThirdRegFragment()
            3 -> fragment = FourRegFragment()
            4 -> fragment = fiveRegFragment()
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
}