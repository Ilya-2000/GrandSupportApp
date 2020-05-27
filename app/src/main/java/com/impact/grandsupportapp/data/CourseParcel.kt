package com.impact.grandsupportapp.data

import android.os.Parcel
import android.os.Parcelable

class CourseParcel(): Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<CourseParcel> {
        override fun createFromParcel(parcel: Parcel): CourseParcel {
            return CourseParcel(parcel)
        }

        override fun newArray(size: Int): Array<CourseParcel?> {
            return arrayOfNulls(size)
        }
    }

}