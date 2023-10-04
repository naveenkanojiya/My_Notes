package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynotes.NoteDatabase.DatabaseBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DatabaseBuilder.getDatabase(this)
    }
}