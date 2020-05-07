package com.impact.grandsupportapp.database

import android.database.Observable
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Flowable
import io.reactivex.Single

class LessonInteractor (private val iLessonRepository: ILessonRepository): ILessonInteractor {
    override fun insert(lesson: Lesson) {
        iLessonRepository.insert(lesson)
    }

    override fun getAll(): Flowable<List<Lesson>> = iLessonRepository.getAll()


    override fun getById(id: Int): Single<List<Lesson>> {
        return getById(id)
    }


    override fun update(lesson: Lesson) {
        iLessonRepository.update(lesson)
    }

    override fun deleteAll() {
        iLessonRepository.deleteAll()
    }
}