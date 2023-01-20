package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.note.databinding.ActivityNoteAddBinding

class NoteAddActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoteAddBinding

    private val database = Database.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSave.setOnClickListener{
            saveNote()
        }

    }

    private fun saveNote() {
        val text = binding.editTextNote.text.toString().trim()
        val priorty = getPriorty()
        val id = database.getNotes().size
        val note = Note(id, text, priorty)
        database.add(note)
        finish()


    }

    private fun getPriorty(): Int {
        val priorty: Int
        if (binding.radioButtonLow.isChecked) {
            priorty = 0
        } else if (binding.radioButtonMedium.isChecked) {
            priorty = 1
        } else {
            priorty = 2
        }
        return priorty
    }


}