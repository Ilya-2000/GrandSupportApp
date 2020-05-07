package com.impact.grandsupportapp.database

import android.database.Observable
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Flowable
import io.reactivex.Single

interface ILessonRepository {
    fun insert(lesson: Lesson)

    fun getAll(): Flowable<List<Lesson>>

    fun getById(id: Int)

    fun update(lesson: Lesson)

    fun deleteAll()


}