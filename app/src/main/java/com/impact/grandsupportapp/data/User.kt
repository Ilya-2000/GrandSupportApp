package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var id: String,
    var name: String,
    var email: String,
    var password: String,
    @ColumnInfo(name = "current_level")
    var currentLevel: Int,
    @ColumnInfo(name = "current_stage")
    val currentStage: Int

)