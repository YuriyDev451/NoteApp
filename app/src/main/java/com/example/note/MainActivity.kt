package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.note.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private var notes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val random = Random
        for (i in 1..20) {
            val note = Note(i, "note" + i, random.nextInt(0, 3))
            notes.add(note)
        }

        showNote()

        binding.floatingActionButton.setOnClickListener(View.OnClickListener() {
            val intent = Intent(this, NoteAddActivity::class.java)
            startActivity(intent)

        })

    }


    private fun showNote() {

        notes.forEach() {
            val view = layoutInflater.inflate(R.layout.note, binding.linerLayout, false)
            val textViewNote: TextView = view.findViewById(R.id.textViewNote)
            textViewNote.text = it.getText()
            val resColorId: Int
            when (it.getPriorty()) {
                0 -> resColorId = android.R.color.holo_green_light
                1 -> resColorId = android.R.color.holo_orange_light
                else -> resColorId = android.R.color.holo_red_light
            }

            val color = ContextCompat.getColor(this, resColorId)
            textViewNote.setBackgroundColor(color)
            binding.linerLayout.addView(view)

        }


    }
}




