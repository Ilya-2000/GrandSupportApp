package com.impact.grandsupportapp.database.lessonDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.impact.grandsupportapp.data.Lesson
import com.impact.grandsupportapp.database.lessonDb.LessonDao
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Lesson::class], version = 1)
abstract class LessonDB: RoomDatabase() {
    abstract fun lessonDao(): LessonDao

    companion object {
        @Volatile
        private var INSTANCE: LessonDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LessonDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LessonDB::class.java,
                    "lesson_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }


}