package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes.NoteDatabase.DatabaseBuilder
import com.example.mynotes.adapter.RvAdapter
import com.example.mynotes.databinding.ActivityMainBinding
import com.example.mynotes.models.NoteTable

class MainActivity : AppCompatActivity() {

    var noteList = ArrayList<NoteTable>()
    lateinit var adapter : RvAdapter
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test1", color_code = 1))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test2", color_code = 2))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test3", color_code = 3))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test4", color_code = 4))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test5", color_code = 5))

        noteList.addAll(DatabaseBuilder.getDatabase(this).getNoteDao().readNotes())
        binding.rv.layoutManager= LinearLayoutManager(this)
        adapter =RvAdapter(this, noteList)
        binding.rv.adapter = adapter
    }
}