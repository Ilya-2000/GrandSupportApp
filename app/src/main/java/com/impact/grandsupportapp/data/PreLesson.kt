package com.impact.grandsupportapp.data

data class PreLesson (
    val id: String,
    val name: String,
    val courseName: String,
    val steps: String,
    var textList: MutableList<String>?,
    var imageList: MutableList<String>?
)