package com.impact.grandsupportapp.database.lessonDb

import androidx.lifecycle.LiveData
import com.impact.grandsupportapp.data.Lesson

class LessonRepository(private val lessonDao: LessonDao) {

    suspend fun insert(lesson: Lesson) {
         lessonDao.insert(lesson)


    }

    val getAll: LiveData<List<Lesson>> = lessonDao.getAll()



    suspend fun getById(id: Int) {
         lessonDao.getById(id)

    }


    suspend fun update(lesson: Lesson) {
        lessonDao.update(lesson)
    }

    suspend fun deleteAll() {
        lessonDao.deleteAll()
    }


}