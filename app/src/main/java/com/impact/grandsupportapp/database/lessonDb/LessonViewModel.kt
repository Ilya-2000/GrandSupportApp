package com.impact.grandsupportapp.database.lessonDb

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.impact.grandsupportapp.data.Lesson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class LessonViewModel (application: Application): AndroidViewModel(application) {
    private val repository: LessonRepository


    init {
        val lessonDao = LessonDB.getDatabase(application, viewModelScope).lessonDao()
        repository = LessonRepository(lessonDao)

    }
    fun getData(lessonAll: MutableList<MutableList<Lesson>>) {
        Log.d("LessonListInViewModel", lessonAll.size.toString())
    }

    fun populateDatabase(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(lesson)

    }
}