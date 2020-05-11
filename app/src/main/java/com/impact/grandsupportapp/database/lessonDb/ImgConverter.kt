package com.impact.grandsupportapp.database.lessonDb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter

class ImgConverter {

    @TypeConverter
    fun fromImageList(imageList: MutableList<String>): String {
        return imageList.joinToString(separator = ",")
        //return textList.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toImageList(data: String): MutableList<String> {
        var list: MutableList<String> = data.split(",").toMutableList()
        return list
    }
}