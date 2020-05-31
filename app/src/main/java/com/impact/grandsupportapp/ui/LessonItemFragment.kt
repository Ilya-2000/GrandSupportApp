package com.impact.grandsupportapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.impact.grandsupportapp.R
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class LessonItemFragment : Fragment() {
    private var lessonTitle: String? = null
    private var lessonText: String? = null
    private var lessonImg: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lesson_item, container, false)
         val textLesson = root.findViewById<TextView>(R.id.lesson_text_item)
         val titleLesson = root.findViewById<TextView>(R.id.lesson_title_item)
         val imageLesson = root.findViewById<ImageView>(R.id.lesson_img_item)
        textLesson.text = lessonText
        titleLesson.text = lessonTitle
        Picasso.get()
            .load(lessonImg)
            .into(imageLesson)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments.let {
            lessonText = it?.getString("text")
            lessonTitle = it?.getString("title")
            lessonImg = it?.getString("image")
        }
    }

}
