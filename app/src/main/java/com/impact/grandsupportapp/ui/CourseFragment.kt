package com.impact.grandsupportapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
import java.util.*
import kotlin.collections.HashMap

/**
 * A simple [Fragment] subclass.
 */
class CourseFragment : Fragment() {
    private val courseBtnList: MutableList<CourseButton>? = null
    private val colorImgList = mutableListOf<Int>(R.drawable.smartphone_custom, R.drawable.alarm_custom, R.drawable.internet_custom, R.drawable.gosuslugi_custom, R.drawable.bank_custom, R.drawable.mail_custom, R.drawable.social_custom, R.drawable.settings_custom)
    private val unColorImgList = mutableListOf<Int>(R.drawable.smartphone_custom_gray, R.drawable.alarm_custom_gray, R.drawable.internet_custom_gray, R.drawable.gosuslugi_custom_gray, R.drawable.bank_custom_gray, R.drawable.mail_custom_gray, R.drawable.social_custom_gray, R.drawable.settings_custom_gray)
    private var course: Course? = null
    private var lessonGlobalMapList: MutableList<HashMap<String, Any>>? = null
    private var globalMap: MutableMap<String, Any>? = null
    private var lessonList: MutableList<Lesson>? = null
    private var user: User? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course, container, false)
        val exitBtn = root.findViewById<ImageButton>(R.id.exit_to_app)
        val courseLayout = root.findViewById<NestedScrollView>(R.id.course_list_layout)
        val progressLayout = root.findViewById<FrameLayout>(R.id.progress_course_layout)
        val navController = findNavController()
        val profileBtn = root.findViewById<ImageButton>(R.id.profile_btn)
        //
        val course1 = root.findViewById<CardView>(R.id.course_item_1)
        val course2 = root.findViewById<CardView>(R.id.course_item_2)
        val course3 = root.findViewById<CardView>(R.id.course_item_3)
        val course4a = root.findViewById<CardView>(R.id.course_item_4a)
        val course4b = root.findViewById<CardView>(R.id.course_item_4b)
        val course5 = root.findViewById<CardView>(R.id.course_item_5)
        val course6a = root.findViewById<CardView>(R.id.course_item_6a)
        val course8 = root.findViewById<CardView>(R.id.course_item_8)
        //
        val image1 = root.findViewById<CircleImageView>(R.id.image_course_1)
        val image2 = root.findViewById<CircleImageView>(R.id.image_course_2)
        val image3 = root.findViewById<CircleImageView>(R.id.image_course_3)
        val image4 = root.findViewById<CircleImageView>(R.id.image_course_4)
        val image5 = root.findViewById<CircleImageView>(R.id.image_course_5)
        val image6 = root.findViewById<CircleImageView>(R.id.image_course_6)
        val image7 = root.findViewById<CircleImageView>(R.id.image_course_7)
        val image10 = root.findViewById<CircleImageView>(R.id.image_course_10)
        val imageList = mutableListOf<CircleImageView>(image1, image2, image3, image4, image5, image6, image7, image10)

         user = User(
            arguments?.get("id")!!.toString(),
            arguments?.get("name")!!.toString(),
             arguments?.get("email")!!.toString(),
            arguments?.get("password")!!.toString(),
            arguments?.get("level") as Int,
            arguments?.get("stage") as Int
        )
        getUserGlobal(user?.email!!)




        var j: Int = 0
        for (i in 0 until user?.currentLevel!!) {

            if (i == 3){
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
        bundle.putString("id",user?.id)
        bundle.putString("name",user?.name)
        bundle.putString("password", user?.password)
        bundle.putString("email", user?.email)
        bundle.putInt("level", user?.currentLevel!!)
        bundle.putInt("stage", user?.currentStage!!)


        exitBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        course1.setOnClickListener {
            if (user?.currentLevel!! > 0) {
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
            if (user?.currentLevel!! > 1) {
                processFun("course_2", bundle, navController, courseLayout, progressLayout)
                bundle.putInt("courseNumber", 2)
                //navController.navigate(R.id.action_courseFragment_to_lessonListFragment, bundle)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course3.setOnClickListener {
            if (user?.currentLevel!! > 2) {
                bundle.putInt("courseNumber", 3)
                processFun("course_3", bundle, navController, courseLayout, progressLayout)
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4a.setOnClickListener {
            if (user?.currentLevel!! > 3) {
                bundle.putInt("courseNumber", 4)
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course4b.setOnClickListener {

            if (user?.currentLevel!! > 3) {
                bundle.putInt("courseNumber", 5)
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course5.setOnClickListener {
            if (user?.currentLevel!! > 4) {
                bundle.putInt("courseNumber", 6)
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        course6a.setOnClickListener {
            if (user?.currentLevel!! > 5) {
                bundle.putInt("courseNumber", 7)
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }

        course8.setOnClickListener {
            if (user?.currentLevel!! > 7) {
                bundle.putInt("courseNumber", 10)
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Курс недоступен.", Toast.LENGTH_LONG).show()
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        profileBtn.setOnClickListener {
            navController.navigate(R.id.action_courseFragment_to_userProfileFragment, bundle)
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
        var global = Global()
        global.currentCourseGlobal = course?.level
        lessonGlobalMapList = preCourse.lessonsList

        Log.d("DataToCourse2", lessonGlobalMapList?.size.toString())

    }
    @UiThread
    suspend fun dataToLessons(lessonMapList: MutableList<HashMap<String, Any>>) {
        var lessonLocal = mutableListOf<Lesson>()
        for (i in 0 until lessonMapList.size) {

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
            /*var l = lesson*/

            Log.d("LessonComplete1", lessonList?.size.toString())
        }
        lessonList = lessonLocal
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


   fun getUserGlobal(email: String) {
       CoroutineScope(Dispatchers.IO).launch {
               getUser(email)
               delay(1000)

       }
   }

    suspend fun getUser(email: String) {
        val userFirestore = FirebaseFirestore.getInstance()
            .collection("users")
            .document(email)
            .get()
            .addOnSuccessListener {

                var preUser = PreUser(
                    it["id"].toString(),
                    it["name"].toString(),
                    it["email"].toString(),
                    it["password"].toString(),
                    it["level"].toString(),
                    it["stage"].toString())


                user = User(
                    preUser.id,
                    preUser.name,
                    preUser.email,
                    preUser.password,
                    preUser.currentLevel.toInt(),
                    preUser.currentStage.toInt()
                )
                Log.d("UserInCourseLoaded", user?.name.toString())
            }
    }

}
