package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes.NoteDatabase.DatabaseBuilder
import com.example.mynotes.ViewModels.MainActivityViewModel
import com.example.mynotes.adapter.RvAdapter
import com.example.mynotes.databinding.ActivityMainBinding
import com.example.mynotes.models.NoteTable
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    var noteList = ArrayList<NoteTable>()
     var adapter : RvAdapter? = null
    lateinit var mainActivityViewModel: MainActivityViewModel
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        var observer  =Observer<List<NoteTable>>{

            noteList.clear()
            noteList.addAll(it)
            if (adapter==null){
                binding.rv.layoutManager = LinearLayoutManager(this)
                adapter = RvAdapter(this,noteList){
                    deleteNote(it)
                }
                binding.rv.adapter = adapter
            }else{
                adapter!!.notifyDataSetChanged()
            }
        }
        mainActivityViewModel.noteList.observe(this,observer)

//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test1", color_code = 1))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test2", color_code = 2))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test3", color_code = 3))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test4", color_code = 4))
//        DatabaseBuilder.getDatabase(this).getNoteDao().insert(NoteTable(data = "test5", color_code = 5))

   //     noteList.addAll(DatabaseBuilder.getDatabase(this).getNoteDao().readNotes())
//        binding.rv.layoutManager= LinearLayoutManager(this)
//        adapter =RvAdapter(this, noteList){
//            deleteNote(it)
//        }
//        binding.rv.adapter = adapter

        binding.Add.setOnClickListener {
            startActivity(Intent(this@MainActivity,AddActivity::class.java))
        }
    }
    fun deleteNote(position: Int){
        var note:NoteTable = noteList.get(position)
        mainActivityViewModel.delete(note)

    }
}