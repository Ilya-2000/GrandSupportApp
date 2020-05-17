package com.impact.grandsupportapp.database.userDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.impact.grandsupportapp.data.User

@Database(entities = [User::class], version = 1)
abstract class UserDb: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: UserDb? = null

        fun getUserDb(context: Context): UserDb? {
            synchronized(UserDb::class) {
                INSTANCE =
                    Room.databaseBuilder(context.applicationContext, UserDb::class.java, "userDB")
                        .build()
            }
            return INSTANCE
        }

        fun deleteUserDb() {
            INSTANCE = null
        }
    }

}