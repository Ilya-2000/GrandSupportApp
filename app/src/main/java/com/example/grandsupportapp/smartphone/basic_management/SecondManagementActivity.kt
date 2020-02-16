package com.example.grandsupportapp.smartphone.basic_management

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.grandsupportapp.R
import com.example.grandsupportapp.adapters.CallVPAdapter
import com.example.grandsupportapp.smartphone.calls.*

class SecondManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_management)
        val vp = findViewById<ViewPager>(R.id.control_vp)
        if (vp != null) {
            val adapter = ManagementVPAdapter(supportFragmentManager)
            vp.adapter = adapter
        }
    }
}
class ManagementVPAdapter internal constructor(fragmentManager: androidx.fragment.app.FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 2
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FirstManagementFragment()
            1 -> fragment = SecondManagementFragment()


        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }


}
