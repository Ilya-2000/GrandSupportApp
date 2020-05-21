package com.impact.grandsupportapp.database.userDb

import androidx.room.*
import com.impact.grandsupportapp.data.User

@Dao
interface UserDao {

    @Query("SELECT * from User WHERE id == :uid")
    fun getUserById(uid: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}