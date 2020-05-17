package com.impact.grandsupportapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    var id: String,
    val name: String,
    val email: String,
    val password: String,
    @ColumnInfo(name = "current_level")
    val currentLevel: Int,
    @ColumnInfo(name = "current_stage")
    val currentStage: Int

)