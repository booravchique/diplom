package com.example.diplom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "profInfo")
data class ProfInfo (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "personName")
    var name: String,
    @ColumnInfo(name = "personSurname")
    var surname: String,
    @ColumnInfo(name = "personMiddleName")
    var middleName: String,
    @ColumnInfo(name = "personCollage")
    var studyAt: String,
    @ColumnInfo(name = "personGroup")
    var group: String,
    @ColumnInfo(name = "personNumber")
    var Birthday: String,
    @ColumnInfo(name = "personPassword")
    var Email: String,
        )
