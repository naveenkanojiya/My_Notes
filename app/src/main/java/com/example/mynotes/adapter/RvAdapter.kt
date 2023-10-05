package com.example.mynotes.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.NoteDatabase.DatabaseBuilder
import com.example.mynotes.databinding.RvItemBinding
import com.example.mynotes.models.NoteTable

class RvAdapter(var context:Context, var noteList:ArrayList<NoteTable>):RecyclerView.Adapter<RvAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding :RvItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.note.text = noteList.get(position).data

        holder.itemView.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                DatabaseBuilder.getDatabase(context).getNoteDao().delete(noteList.get(position))
                return true
            }

        })
    }
}
