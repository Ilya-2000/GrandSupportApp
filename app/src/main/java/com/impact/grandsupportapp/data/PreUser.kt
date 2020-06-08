package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo

data class PreUser(
    var id: String,
    var name: String,
    var email: String,
    var password: String,
    val currentLevel: String,
    val currentStage: String
)