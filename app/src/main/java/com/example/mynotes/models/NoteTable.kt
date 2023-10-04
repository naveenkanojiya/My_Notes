package com.example.mynotes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "note_table")
class NoteTable (
    @PrimaryKey(autoGenerate = true) var key: Int,
    @ColumnInfo(name = "data") val data:String,
    @ColumnInfo(name = "color_code") val color_code :Int
 //   @ColumnInfo(name = "date") val date:Date? = null
)