package com.example.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val listener: Listener) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
     var notes = ArrayList<Note>()
        set(notesValue) {
            field = notesValue
            notifyDataSetChanged()
        }

    fun getArr(): ArrayList<Note> {
        return ArrayList(notes)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
      //  val note: Note = notes.get(position)
        holder.bind(notes[position], listener)
      //  holder.textViewNote.text = note.getText()
       // val resColorId: Int
      //  when (note.getPriorty()) {
       //     0 -> resColorId = android.R.color.holo_green_light
       //     1 -> resColorId = android.R.color.holo_orange_light
       //     else -> resColorId = android.R.color.holo_red_light
       // }



      //  val color = ContextCompat.getColor(holder.itemView.context, resColorId)
      //  holder.textViewNote.setBackgroundColor(color)

    }

    override fun getItemCount(): Int {
        return notes.size
    }


     class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNote: TextView = view.findViewById(R.id.textViewNote)

        fun bind (note: Note, listener: Listener) {
            textViewNote.text = note.getText()
            itemView.setOnClickListener{
                listener.onClick(note)
            }
            val resColorId: Int
            when (note.getPriorty()) {
                0 -> resColorId = android.R.color.holo_green_light
                1 -> resColorId = android.R.color.holo_orange_light
                else -> resColorId = android.R.color.holo_red_light
            }
            val color = ContextCompat.getColor(itemView.context, resColorId)
            textViewNote.setBackgroundColor(color)

        }


    }

        interface Listener {
            fun onClick(note:Note)
        }

}