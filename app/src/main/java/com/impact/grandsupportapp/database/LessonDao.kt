package com.impact.grandsupportapp.database

import android.database.Observable
import androidx.room.*
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
public interface LessonDao {
    @Query("SELECT * FROM lesson ORDER BY id")
    fun getAll(): Flowable<List<Lesson>>

    @Query("SELECT * FROM lesson WHERE id = :id")
    fun getById(id: Int): Single<Lesson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lesson: Lesson): Completable

    @Update
    fun update(lesson: Lesson)

    @Query("DELETE FROM lesson")
    fun deleteAll()


}