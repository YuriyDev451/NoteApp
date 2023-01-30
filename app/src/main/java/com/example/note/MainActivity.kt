package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private val database = Database.instance
    private var notesAdapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val manager = LinearLayoutManager(this)
        notesAdapter = NotesAdapter()

        binding.recyclerViewNotes.layoutManager = manager
        binding.recyclerViewNotes.adapter = notesAdapter


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, NoteAddActivity::class.java)
            startActivity(intent)

        }


    }

    override fun onResume() {
        super.onResume()
        showNote()
    }

    private fun showNote() {

        notesAdapter.notes = database.getNotes()
    }
}




