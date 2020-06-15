package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.storage.FirebaseStorage

import com.impact.grandsupportapp.R
//import com.impact.grandsupportapp.adapter.LessonViewPagerAdapter
import com.impact.grandsupportapp.adapter.LessonVpAdapter
import com.impact.grandsupportapp.data.Global
import com.impact.grandsupportapp.data.Lesson
import github.chenupt.springindicator.SpringIndicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class LessonPlaceFragment : Fragment() {
    private var imageList: MutableList<String>? = null
    private var imageByteGlobalList: MutableList<ByteArray>? = null
    private var lesson: Lesson? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_place, container, false)
        val tabLayout = root.findViewById<TabLayout>(R.id.tab_lesson)
        val closeBtn = root.findViewById<ImageButton>(R.id.back_to_lesson_btn)
        val checkBtn = root.findViewById<ImageButton>(R.id.check_lesson_end_btn)
        lesson = arguments?.get("lesson") as Lesson

        var count: Int
        count = arguments?.get("count") as Int
        val navController = findNavController()
        val global = Global()
        //count = global.countGlobal!!
        global.lesson = lesson
        //imageList = lesson?.imageList
        val viewPager = root.findViewById<ViewPager2>(R.id.lesson_vp)
        Log.d("LessonInPlace", lesson?.name.toString())
        //getImage(imageList)
        val adapter = LessonVpAdapter(lesson, requireContext())
        //val adapter = LessonViewPagerAdapter(requireActivity(), lesson)
        viewPager.adapter = adapter
        //viewPager.offscreenPageLimit = lesson?.steps!!
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val steps = lesson?.steps
            tab.text = ("Шаг " + (position + 1).toString())
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == (lesson?.steps?.minus(1))) {
                    checkBtn.visibility = View.VISIBLE
                } else {
                    checkBtn.visibility = View.GONE
                }
            }
        })

        checkBtn.setOnClickListener {
            if (count != global.stage) {
                global.stage = global.stage + 1
            } else if (global.level != global.currentCourseGlobal) {
                global.level = global.level +1
            } else {
                global.stage = 0

            }


            requireActivity().onBackPressed()
        }
        closeBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return root
    }







    /*fun getImage(imageList: MutableList<String>?) {
        CoroutineScope(Dispatchers.IO).launch {
            imageByteGlobalList = downloadImage(imageList!!)
            delay(3000)
            Log.d("ImageDownload",imageByteGlobalList?.size.toString() )

        }
    }

    suspend fun downloadImage(imageList: MutableList<String>): MutableList<ByteArray>? {
        var imageByteList: MutableList<ByteArray>? = null
        for (i in 0 until imageList.size) {
            val imageUrl = imageList[i]
            val byteSize: Long = 1024 * 1024
            val storageReference = FirebaseStorage.getInstance().reference.child(imageUrl)
            storageReference.getBytes(byteSize)
                .addOnSuccessListener {
                    imageByteList?.add(it)
                }
                .addOnFailureListener {
                    Log.d("ImageDownloadError", it.message.toString())
                }


        }
        return  imageByteList
    }*/

}

