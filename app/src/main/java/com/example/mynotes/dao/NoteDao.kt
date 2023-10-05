package com.example.mynotes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mynotes.models.NoteTable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (note : NoteTable)

    @Update
    fun update(update: NoteTable)

    @Delete
    fun delete(note: NoteTable)

    @Query("SELECT * FROM note_table")
    fun readNotes(): List<NoteTable>

//    @Delete
//    fun deleteAll()

}



