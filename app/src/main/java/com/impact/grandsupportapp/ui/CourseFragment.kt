package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.CourseButton
import com.impact.grandsupportapp.data.User
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

/**
 * A simple [Fragment] subclass.
 */
class CourseFragment : Fragment() {
    private val courseBtnList: MutableList<CourseButton>? = null
    private val colorImgList = mutableListOf<Int>(R.drawable.smartphone_custom64)
    private val unColorImgList = mutableListOf<Int>(R.drawable.smartphone_custom_gray_64)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course, container, false)
        val navController = findNavController()
        //
        val course1 = root.findViewById<CardView>(R.id.course_item_1)
        val course2 = root.findViewById<CardView>(R.id.course_item_2)
        val course3 = root.findViewById<CardView>(R.id.course_item_3)
        val course4a = root.findViewById<CardView>(R.id.course_item_4a)
        val course4b = root.findViewById<CardView>(R.id.course_item_4b)
        val course5 = root.findViewById<CardView>(R.id.course_item_5)
        val course6a = root.findViewById<CardView>(R.id.course_item_6a)
        val course6b = root.findViewById<CardView>(R.id.course_item_6b)
        val course7 = root.findViewById<CardView>(R.id.course_item_7)
        val course8 = root.findViewById<CardView>(R.id.course_item_8)
        //
        val image1 = root.findViewById<CircleImageView>(R.id.image_course_1)
        val image2 = root.findViewById<CircleImageView>(R.id.image_course_2)
        val image3 = root.findViewById<CircleImageView>(R.id.image_course_3)
        val image4 = root.findViewById<CircleImageView>(R.id.image_course_4)
        val image5 = root.findViewById<CircleImageView>(R.id.image_course_5)
        val image6 = root.findViewById<CircleImageView>(R.id.image_course_6)
        val image7 = root.findViewById<CircleImageView>(R.id.image_course_7)
        val image8 = root.findViewById<CircleImageView>(R.id.image_course_8)
        val image9 = root.findViewById<CircleImageView>(R.id.image_course_9)
        val image10 = root.findViewById<CircleImageView>(R.id.image_course_10)
        val imageList = mutableListOf<CircleImageView>(image1, image2, image3, image4, image5, image6, image7, image8, image9, image10)


        var id = arguments?.get("id")?.toString()
        var user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
            arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )

        Log.d("UserIsReady", user.name)
        var j: Int = 0
        for (i in 0 until user.currentLevel) {

            if (i == 3 || i == 6){
                Picasso.get()
                    .load(colorImgList[j])
                    .into(imageList[j])
                j += 1
                Picasso.get()
                    .load(colorImgList[j])
                    .into(imageList[j])
            } else {
                Picasso.get()
                    .load(colorImgList[j])
                    .into(imageList[j])
            }
            j++
        }
        val bundle = Bundle()
        bundle.putString("id",user.id)
        bundle.putString("name",user.name)
        bundle.putString("password", user.password)
        bundle.putString("email", user.email)
        bundle.putInt("level", user.currentLevel)
        bundle.putInt("stage", user.currentStage)
        course1.setOnClickListener {
            if (user.currentLevel > 0) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course2.setOnClickListener {
            if (user.currentLevel > 1) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course3.setOnClickListener {
            if (user.currentLevel > 2) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4a.setOnClickListener {
            if (user.currentLevel > 3) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4b.setOnClickListener {
            if (user.currentLevel > 3) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course5.setOnClickListener {
            if (user.currentLevel > 4) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course6a.setOnClickListener {
            if (user.currentLevel > 5) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course6b.setOnClickListener {
            if (user.currentLevel > 5) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course7.setOnClickListener {
            if (user.currentLevel > 6) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course8.setOnClickListener {
            if (user.currentLevel > 7) {
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

}
