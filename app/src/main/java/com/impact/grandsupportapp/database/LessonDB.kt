package com.impact.grandsupportapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.impact.grandsupportapp.data.Lesson

@Database(entities = [Lesson::class], version = 1)
abstract class LessonDB: RoomDatabase() {

    abstract fun lessonDao(): LessonDao


}