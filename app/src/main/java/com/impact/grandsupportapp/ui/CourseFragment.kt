package com.impact.grandsupportapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.UiThread
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.core.widget.NestedScrollView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.*
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class CourseFragment : Fragment() {
    private val courseBtnList: MutableList<CourseButton>? = null
    private val colorImgList = mutableListOf<Int>(R.drawable.smartphone_custom64)
    private val unColorImgList = mutableListOf<Int>(R.drawable.smartphone_custom_gray_64)
    private var course: Course? = null
    private var lessonGlobalMapList: MutableList<HashMap<String, Any>>? = null
    private var globalMap: MutableMap<String, Any>? = null
    private var lessonList: MutableList<Lesson>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course, container, false)
        val courseLayout = root.findViewById<NestedScrollView>(R.id.course_list_layout)
        val progressLayout = root.findViewById<FrameLayout>(R.id.progress_course_layout)
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
                processFun("course_1", bundle, navController, courseLayout, progressLayout)
                /*val handler = Handler().postDelayed(Runnable {
                    Log.d("LessonList", lessonList?.size.toString())
                    navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
                }, 2000)*/

            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course2.setOnClickListener {
            if (user.currentLevel > 1) {
                bundle.putInt("courseNumber", 2)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course3.setOnClickListener {
            if (user.currentLevel > 2) {
                bundle.putInt("courseNumber", 3)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4a.setOnClickListener {
            if (user.currentLevel > 3) {
                bundle.putInt("courseNumber", 4)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4b.setOnClickListener {

            if (user.currentLevel > 3) {
                bundle.putInt("courseNumber", 5)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course5.setOnClickListener {
            if (user.currentLevel > 4) {
                bundle.putInt("courseNumber", 6)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course6a.setOnClickListener {
            if (user.currentLevel > 5) {
                bundle.putInt("courseNumber", 7)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course6b.setOnClickListener {
            if (user.currentLevel > 5) {
                bundle.putInt("courseNumber", 8)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course7.setOnClickListener {
            if (user.currentLevel > 6) {
                bundle.putInt("courseNumber", 9)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course8.setOnClickListener {
            if (user.currentLevel > 7) {
                bundle.putInt("courseNumber", 10)
                navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    private fun processFun(courseName: String, bundle: Bundle, navController: NavController, courseLayout: NestedScrollView, progressBarLayout: FrameLayout) {
        getProgressBar(courseLayout, progressBarLayout)
        CoroutineScope(Dispatchers.IO).launch {
            async {
                getData(courseName)
            }.await()
            delay(6000)
                Log.d("DataGlobal4", globalMap?.size.toString())
                dataToCourse(globalMap)
                Log.d("DataToCourse3", course?.id.toString())
                dataToLessons(lessonGlobalMapList!!)
                Log.d("LessonComplete3", lessonList?.size.toString())
                goToLesson(bundle, navController)

        }
    }

    @UiThread
    suspend fun getData(courseName: String) {
        var data = getAllData(courseName)
        Log.d("LoadedData", data?.size.toString())
    }

     private fun getAllData(courseName: String): MutableMap<String, Any>?{
        var dataMap: MutableMap<String, Any>? = null
        var firestore = FirebaseFirestore.getInstance()
            .collection("courses")
            .document(courseName)
            .get()
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    it.addOnSuccessListener { documentSnapshot ->
                        dataMap = documentSnapshot.data
                        globalMap = dataMap
                        Log.d("DataSuccess", dataMap?.size.toString() + " + " + documentSnapshot.data?.size.toString())
                        Log.d("DataGlobal1", globalMap?.size.toString())
                    }
                }
                Log.d("DataGlobal2", globalMap?.size.toString())

            }.addOnFailureListener {
                Log.d("DownloadingCourse", it.message.toString())
            }
         Log.d("DataGlobal3", globalMap?.size.toString())
        return globalMap
    }
    @UiThread
    suspend fun dataToCourse(dataMap: MutableMap<String, Any>?) {
        var preCourse = PreCourse(
            dataMap?.get("name").toString(),
            dataMap?.get("id").toString(),
            dataMap?.get("level").toString(),
            dataMap?.get("lessons_id") as MutableList<String>,
            dataMap!!["lesson_list"] as MutableList<HashMap<String, Any>>)
        Log.d("DataToCourse1", preCourse.id)
        course = Course(
            preCourse.name,
            preCourse.id.toInt(),
            preCourse.level.toInt(),
            preCourse.lessonsId as MutableList<Int>
        )
        lessonGlobalMapList = preCourse.lessonsList

        Log.d("DataToCourse2", lessonGlobalMapList?.size.toString())

    }
    @UiThread
    suspend fun dataToLessons(lessonMapList: MutableList<HashMap<String, Any>>) {
        for (i in 0 until lessonMapList.size) {
            var lessonLocal = mutableListOf<Lesson>()
            var preLesson = PreLesson(
                lessonMapList[i]["lesson_id"].toString(),
                lessonMapList[i]["name"].toString(),
                lessonMapList[i]["course_name"].toString(),
                lessonMapList[i]["steps"].toString(),
                lessonMapList[i]["text_list"] as MutableList<String>,
                lessonMapList[i]["image_list"] as MutableList<String>
            )
            var lesson = Lesson(
                preLesson.id.toInt(),
                preLesson.name,
                preLesson.courseName,
                preLesson.steps.toInt(),
                preLesson.textList,
                preLesson.imageList
            )
            lessonLocal.add(lesson)
            lessonList = lessonLocal
            Log.d("LessonComplete1", lessonList?.size.toString())
        }
        Log.d("LessonComplete2", lessonList?.size.toString())
    }
    @UiThread
    suspend fun goToLesson(bundle: Bundle, navController: NavController) {
        bundle.putInt("courseNumber", 1)

        //bundle.putParcelable("course", course)
        bundle.putParcelableArrayList("lessonList", ArrayList(lessonList!!))
        Log.d("LessonList", lessonList?.size.toString())
        navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
    }

    fun getProgressBar(courseLayout: NestedScrollView, progressBarLayout: FrameLayout) {
        courseLayout.visibility = View.GONE
        progressBarLayout.visibility = View.VISIBLE
    }

}
