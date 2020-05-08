package com.impact.grandsupportapp.database.courseDb

import androidx.room.*
import com.impact.grandsupportapp.data.Course
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CourseDao {
    @Query("SELECT * FROM course ORDER BY id")
    fun getAll(): Flowable<List<Course>>

    @Query("SELECT * FROM course WHERE id = :id")
    fun getById(id: Int): Single<Course>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(course: Course): Completable

    @Update
    fun update(course: Course)

    @Query("DELETE FROM course")
    fun deleteAll()
}