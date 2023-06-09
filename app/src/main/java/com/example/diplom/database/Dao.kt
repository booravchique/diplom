package com.example.diplom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: ProfInfo)
    @Query("SELECT * FROM profInfo")
    fun getAllItem(): Flow<List<ProfInfo>>
}