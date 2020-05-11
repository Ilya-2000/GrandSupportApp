package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.impact.grandsupportapp.database.lessonDb.ImgConverter
import com.impact.grandsupportapp.database.lessonDb.LessonConverter

@Entity
data class Lesson(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "course_name")
    val courseName: String,
    val steps: Int,
    @ColumnInfo(name = "text_list")
    @TypeConverters(LessonConverter::class)
    var textList: MutableList<String>,
    @ColumnInfo(name = "image_list")
    @TypeConverters(ImgConverter::class)
    var imageList: MutableList<String>

)