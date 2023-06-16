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
    @Query("SELECT personName, personSurname, personMiddleName, personCollage, personGroup, personNumber, personPassword, MAX(id) FROM profInfo LIMIT 1")
    fun getLastItem(): ProfInfo
}