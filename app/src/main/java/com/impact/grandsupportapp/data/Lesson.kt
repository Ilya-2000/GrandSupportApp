package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "course_name")
    val courseName: String,
    val steps: Int,
    @ColumnInfo(name = "text_list")
    var textList: MutableList<String>,
    @ColumnInfo(name = "image_list")
    var imageList: MutableList<String>

)