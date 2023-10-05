package com.example.mynotes.NoteDatabase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.InternalCoroutinesApi

object DatabaseBuilder {

    private var INSTANCE : NoteDatabase? = null
    //if data base is not create them we will create and return otherwise if create we will directly return..........
    @OptIn(InternalCoroutinesApi::class)
    fun getDatabase(context : Context):NoteDatabase {
        if (INSTANCE == null) {

            synchronized(NoteDatabase::class){
                INSTANCE = Room.databaseBuilder(
                    context,NoteDatabase::class.java,"note_database.db"
                ).allowMainThreadQueries().setJournalMode(RoomDatabase.JournalMode.TRUNCATE).fallbackToDestructiveMigration().build()
            }
        }
        return INSTANCE!!

    }



}