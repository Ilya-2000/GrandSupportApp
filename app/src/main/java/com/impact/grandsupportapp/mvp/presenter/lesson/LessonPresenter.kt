package com.impact.grandsupportapp.mvp.presenter.lesson

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.database.ILessonInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LessonPresenter(private val iLessonInteractor: ILessonInteractor): ILessonPresenter {
    private val allLessons: MutableLiveData<List<Lesson>> = MutableLiveData()
    private val lessonUnit: MutableLiveData<List<Lesson>> = MutableLiveData()

    init {
        loadLessons()
    }

    override fun insert(lesson: Lesson) {
        iLessonInteractor.insert(lesson)
    }

    override fun getAll(): LiveData<List<Lesson>> {
        return allLessons
    }

    override fun getById(id: Int) {
         iLessonInteractor.getById(id)
    }

    override fun update(lesson: Lesson) {
        iLessonInteractor.update(lesson)
    }

    override fun deleteAll() {
        iLessonInteractor.deleteAll()
    }

    override fun loadLessons() {
        iLessonInteractor.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: List<Lesson>? ->  allLessons.postValue(t)}, {t ->  Log.d("RxJava", "Error getting values")})
    }

    override fun getByIdLesson(id: Int) {

        iLessonInteractor.getById(id)
        /*iLessonInteractor.getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: List<Lesson>? ->  lessonUnit.postValue(t) }, {t ->  Log.d("RxJava", "Error getting values")})*/
    }
}