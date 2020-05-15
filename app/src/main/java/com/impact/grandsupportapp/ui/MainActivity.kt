package com.impact.grandsupportapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.database.lessonDb.LessonViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var lessonViewModel: LessonViewModel
    //private var dataList: MutableList<MutableList<Lesson>> = MutableList<MutableList<Lesson>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainFragment = findViewById<View>(R.id.fragment_main)
        lessonViewModel = ViewModelProvider(this).get(LessonViewModel::class.java)
        val handler = Handler().postDelayed(Runnable {
            //writeData()
        }, 7000)

    }

    fun writeData(lessonGlobalList: MutableList<MutableList<Lesson>>){
        lessonViewModel.getData(lessonGlobalList)
    }

    fun setData(dataList: MutableList<MutableList<Lesson>>): MutableList<MutableList<Lesson>> {
        return dataList
    }


}



