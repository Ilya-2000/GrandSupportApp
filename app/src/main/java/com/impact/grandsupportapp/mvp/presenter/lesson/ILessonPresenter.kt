package com.impact.grandsupportapp.mvp.presenter.lesson

import androidx.lifecycle.LiveData
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Single

interface ILessonPresenter {
    fun insert(lesson: Lesson)

    fun getAll(): LiveData<List<Lesson>>

    fun getById(id: Int)

    fun update(lesson: Lesson)

    fun deleteAll()

    fun loadLessons()

    fun getByIdLesson(id: Int)
}