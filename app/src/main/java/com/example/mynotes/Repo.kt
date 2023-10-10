package com.example.mynotes

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mynotes.NoteDatabase.DatabaseBuilder
import com.example.mynotes.dao.NoteDao
import com.example.mynotes.models.NoteTable

class Repo(context: Context) {
    var daoObject:NoteDao = DatabaseBuilder.getDatabase(context).getNoteDao()

    fun readNotes():LiveData<List<NoteTable>>{
        return daoObject.readNotes()
    }
    fun insert(note:NoteTable){
        daoObject.insert(note)
    }
    fun update(note: NoteTable){
        daoObject.update(note)
    }
    fun delete(note:NoteTable){
        daoObject.delete(note)
    }
}