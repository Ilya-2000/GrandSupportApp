package com.impact.grandsupportapp.adapter

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.ui.LessonItemFragment

class LessonViewPagerAdapter(activity: FragmentActivity, private val item: Lesson?): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = item?.steps!!



    override fun createFragment(position: Int): Fragment = LessonItemFragment().apply {
        arguments = bundleOf(
            "text" to item?.textList?.get(position),
            "title" to item?.name,
            "image" to item?.imageList?.get(position)
        )
    }
}