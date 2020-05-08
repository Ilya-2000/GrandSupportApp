package com.impact.grandsupportapp.database.lessonDb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.impact.grandsupportapp.data.Lesson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonViewModel (application: Application): AndroidViewModel(application) {
    private val repository: LessonRepository
    val allLessons: LiveData<List<Lesson>>

    init {
        val lessonDao = LessonDB.getDatabase(application).lessonDao()
        repository = LessonRepository(lessonDao)
        allLessons = repository.getAll
    }

    fun insert(lesson: Lesson) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(lesson)
    }
}