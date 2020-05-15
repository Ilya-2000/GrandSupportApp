package com.impact.grandsupportapp.data

data class PreCourse(
    val name: String,
    var id: String,
    val level: String,
    var lessonsId: MutableList<String>?,
    var lessonsList: MutableList<HashMap<String, Any>>
)