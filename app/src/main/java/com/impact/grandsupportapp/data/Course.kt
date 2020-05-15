package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Course(
    val name: String,
    @PrimaryKey
    var id: Long,
    val level: Long,
    @ColumnInfo(name = "lessons_id")
    val lessonsId: MutableList<Long>?,
    @ColumnInfo(name = "lessons_list")
    var lessonsList: MutableList<HashMap<String, Any>>
)