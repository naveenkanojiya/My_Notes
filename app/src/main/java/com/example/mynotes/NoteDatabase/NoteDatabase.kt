package com.example.mynotes.NoteDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynotes.dao.NoteDao
import com.example.mynotes.models.NoteTable


@Database(entities = [NoteTable::class], exportSchema = false , version = 3)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
}