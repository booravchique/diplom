package com.example.diplom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [ProfInfo::class], version = 1)
abstract class RoomDBProfile: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDBProfile(context: Context): RoomDBProfile {
            return Room.databaseBuilder(
                context.applicationContext,
                RoomDBProfile::class.java,
                "profile.db"
            ).build()
        }
    }
}