package com.impact.grandsupportapp.mvp.presenter.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.impact.grandsupportapp.data.Lesson

class LessonPresenter: ILessonPresenter {
    private val allLessons: MutableLiveData<List<Lesson>> = MutableLiveData()
    private val lessonUnit: MutableLiveData<List<Lesson>> = MutableLiveData()

    init {
        loadLessons()
    }

    override fun insert(lesson: Lesson) {

    }

    override fun getAll(): LiveData<List<Lesson>> {
        return allLessons
    }

    override fun getById(id: Int) {

    }

    override fun update(lesson: Lesson) {

    }

    override fun deleteAll() {

    }

    override fun loadLessons() {
        /*iLessonInteractor.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: List<Lesson>? ->  allLessons.postValue(t)}, {t ->  Log.d("RxJava", "Error getting values")})*/
    }

    override fun getByIdLesson(id: Int) {

        //iLessonInteractor.getById(id)
        /*iLessonInteractor.getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: List<Lesson>? ->  lessonUnit.postValue(t) }, {t ->  Log.d("RxJava", "Error getting values")})*/
    }
}