package com.impact.grandsupportapp.database

import android.database.Observable
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Flowable
import io.reactivex.Single

interface ILessonInteractor {
    fun insert(lesson: Lesson)

    fun getAll(): Flowable<List<Lesson>>

    fun getById(id: Int): Single<List<Lesson>>

    fun update(lesson: Lesson)

    fun deleteAll()
}
