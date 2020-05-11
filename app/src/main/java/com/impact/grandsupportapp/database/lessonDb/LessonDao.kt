package com.impact.grandsupportapp.database.lessonDb

import android.database.Observable
import androidx.lifecycle.LiveData
import androidx.room.*
import com.impact.grandsupportapp.data.Lesson
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
public interface LessonDao {
    @Query("SELECT * FROM lesson ORDER BY id")
    fun getAll(): LiveData<List<Lesson>>

    @Query("SELECT * FROM lesson WHERE id = :id")
    fun getById(id: Int): Single<Lesson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)

    @Update
    suspend fun update(lesson: Lesson)

    @Query("DELETE FROM lesson")
    suspend fun deleteAll()


}