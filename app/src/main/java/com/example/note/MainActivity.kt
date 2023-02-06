package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.note.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(), NotesAdapter.Listener {


    lateinit var binding: ActivityMainBinding
    private val database = Database.instance
    private var notesAdapter = NotesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val manager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter(this)

        binding.recyclerViewNotes.layoutManager = manager
        binding.recyclerViewNotes.adapter = notesAdapter


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, NoteAddActivity::class.java)
            startActivity(intent)

        }

        val myCallback = object: ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val note = notesAdapter.getArr().get(position)
                database.remove(note.getId())
                showNote()
            }

        }
        val myHelper = ItemTouchHelper(myCallback)
        myHelper.attachToRecyclerView(binding.recyclerViewNotes)


    }

    override fun onResume() {
        super.onResume()
        showNote()
    }

    private fun showNote() {

        notesAdapter.notes = database.getNotes()
    }

    override fun onClick(note: Note) {
        database.remove(note.getId())
        showNote()
    }
}




