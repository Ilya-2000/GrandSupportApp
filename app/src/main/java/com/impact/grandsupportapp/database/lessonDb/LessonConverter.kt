package com.impact.grandsupportapp.database.lessonDb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.impact.grandsupportapp.data.Lesson
import java.util.*
import java.util.stream.Collectors

class LessonConverter {

        @TypeConverter
        fun fromTextList(textList: MutableList<String>): String {
            val a = textList.joinToString(separator = ",")
            //return textList.stream().collect(Collectors.joining(","))
            return a
        }

        @TypeConverter
        fun toTextList(data: String): MutableList<String> {
            var list: MutableList<String> = data.split(",").toMutableList()
            return list
        }

}