package com.impact.grandsupportapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Course(
    val name: String,
    @PrimaryKey
    val number: Int,
    val level: Int,
    val lessonsId: List<Int>
)