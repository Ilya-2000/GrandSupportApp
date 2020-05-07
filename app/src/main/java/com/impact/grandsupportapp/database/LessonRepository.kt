package com.impact.grandsupportapp.database

import android.database.Observable
import android.util.Log
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.*;

class LessonRepository(private val lessonDao: LessonDao): ILessonRepository {
    override fun insert(lesson: Lesson) {
         lessonDao.insert(lesson)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({Log.d("Insert", "Success")},
                {Log.d("Insert", "Fail")})

    }

    override fun getAll(): Flowable<List<Lesson>> = lessonDao.getAll()



    override fun getById(id: Int) {
         lessonDao.getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({Log.d("GetById", "Success")},
                {Log.d("GetById", "Fail")})

    }


    override fun update(lesson: Lesson) {
        lessonDao.update(lesson)
    }

    override fun deleteAll() {
        Completable.fromAction { lessonDao.deleteAll() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({Log.d("Delete", "Success")},
            {Log.d("Delete", "Fail")})
    }


}