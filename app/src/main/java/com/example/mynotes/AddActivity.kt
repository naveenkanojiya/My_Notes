package com.example.mynotes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mynotes.ViewModels.AddActivityViewModel
import com.example.mynotes.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {


    private lateinit var addActivityViewModel: AddActivityViewModel
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addActivityViewModel = ViewModelProvider(this).get(AddActivityViewModel::class.java)

        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.right_menu,menu)
        menuInflater.inflate(R.menu.menu_add,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){

        }
        return super.onOptionsItemSelected(item)
    }
}