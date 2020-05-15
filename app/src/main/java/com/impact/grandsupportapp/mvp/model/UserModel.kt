package com.impact.grandsupportapp.mvp.model

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.impact.grandsupportapp.data.*
import com.impact.grandsupportapp.database.lessonDb.LessonDao
import com.impact.grandsupportapp.database.lessonDb.LessonViewModel
import com.impact.grandsupportapp.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class UserModel {
    private lateinit var lessonViewModel: LessonViewModel
    var courseMap = HashMap<String, Any>()
    var globalLessonList = mutableListOf<MutableList<Lesson>>()

    fun WriteNewUser(user: User) {
        FirebaseFirestore.getInstance()
            .collection("users")
            .add(user)
            .addOnCompleteListener {
                Log.d("reg", it.result.toString())
                if(it.isSuccessful) {

                }
            }
            .addOnFailureListener {
                    exception ->
                Log.d("reg", exception.message.toString())

            }
    }

    fun ClearUserData(user: User) {

    }

     fun loadLesson(activity: MainActivity) {
         val courseIdList = mutableListOf<String>("course_1", "course_2")
         //lessonViewModel = ViewModelProvider(activity).get(LessonViewModel::class.java)
         var mainActivity = MainActivity()
         var lessonAllList = mutableListOf<MutableList<Lesson>>()



        for (i in 0 until courseIdList.size) {
            FirebaseFirestore.getInstance()
                .collection("courses")
                .document(courseIdList[i])
                .get()
                .addOnSuccessListener {
                    Log.d("LoadedData", it.data.toString())

                    courseMap.putAll(it.data!!)
                    Log.d("LessonLoadData", courseMap.toString())
                    lessonAllList.addAll(dataProcessing(courseMap))
                    val handler = Handler().postDelayed(Runnable {
                        //mainActivity.
                        Log.d("LessonAllList", lessonAllList[i].toString())
                    }, 1000)


                    /*var course = Course(it["name"] as String, it["id"] as Long, it["level"] as Long,
                        it["lesson_id"] as MutableList<Long>?, it["lesson_list"] as MutableList<HashMap<String, Any>>)
                    var lessonMap = HashMap<String, Any>()
                    for (j in  course.lessonsList) {
                        val lesson = Lesson(j["lesson_id"] as Long, j["name"] as String, j["course_name"] as String,
                        j["steps"] as Long, j["text_list"] as MutableList<String>, j["image_list"] as MutableList<String>)
                           mainActivity.writeData(lesson)
                            Log.d("LessonLoadData", lesson.name)
                    }*/


                }
                .addOnFailureListener {
                    Log.d("LoadedData", it.message.toString())
                }
        }

         /*val handler = Handler().postDelayed(Runnable {
             lessonAllList = dataProcessing(courseMap)
             Log.d("LessonMap", courseMap.toString())
         }, 1000)*/

         /*if (lessonAllList.isNotEmpty()) {
             var global = Global()
             //global.lessonGlobalList = lessonAllList
             mainActivity.writeData(lessonAllList)
         }*/
    }

    private fun dataProcessing(courseMap: HashMap<String, Any>): MutableList<MutableList<Lesson>> {

        var lessonMap: HashMap<String, Any?> = hashMapOf()
        var lessonList = mutableListOf<Lesson>()
        var lessonMapList = mutableListOf<HashMap<String, Any>>()
        var preCourse = PreCourse(
            courseMap.get("name").toString(),
            courseMap.get("id").toString(),
            courseMap.get("level").toString(),
            courseMap.get("lessons_id") as MutableList<String>,
            courseMap.get("lesson_list") as MutableList<HashMap<String, Any>>
        )
        Log.d("CourseLoaded", preCourse.lessonsList.size.toString())
        lessonMapList.addAll(preCourse.lessonsList)

        for (i in 0 until preCourse.lessonsList.size) {
            var currentLessonMap = hashMapOf<String, Any>()
            currentLessonMap = preCourse.lessonsList[i]
            var preLesson = PreLesson(
                currentLessonMap["lesson_id"].toString(),
                currentLessonMap["name"].toString(),
                currentLessonMap["course_name"].toString(),
                currentLessonMap["steps"].toString(),
                currentLessonMap["text_list"] as MutableList<String>,
                currentLessonMap["image_list"] as MutableList<String>
            )
            var lesson = Lesson(
                preLesson.id.toInt(),
                preLesson.name,
                preLesson.courseName,
                preLesson.steps.toInt(),
                preLesson.textList,
                preLesson.imageList
            )
            lessonList.add(lesson)
            //отдать список во viewModel и там добавлять в базу данных
            Log.d("LessonListProcess", lessonList[i].name)
        }
        globalLessonList.add(lessonList)
        return globalLessonList

    }



}
