package com.example.mynotes.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Insert
import com.example.mynotes.Repo
import com.example.mynotes.models.NoteTable

class AddActivityViewModel( application: Application , var onSuccess:()->Unit): AndroidViewModel(application) {

    lateinit var repo: Repo
    init {
        repo = Repo(application)
    }
    fun Insert(note:NoteTable){
        repo.insert(note)
        onSuccess
    }
}