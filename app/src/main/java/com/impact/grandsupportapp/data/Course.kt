package com.impact.grandsupportapp.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Course(
    val name: String,
    @PrimaryKey
    var id: Int,
    val level: Int,
    @ColumnInfo(name = "lessons_id")
    val lessonsId: MutableList<Int>?
    //@ColumnInfo(name = "lessons_list")
    //var lessonsList: MutableList<HashMap<String, Any>>
): Parcelable