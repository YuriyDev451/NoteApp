package com.example.note

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.note.databinding.ActivityNoteAddBinding

class NoteAddActivity : AppCompatActivity() {

lateinit var binding: ActivityNoteAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)


        saveNote()


    }

    private fun saveNote () {
        val string = binding.editTextNote.text.trim()
        val position = getPosition()
    }

    private fun getPosition(): Int {
        val position: Int
        if (binding.radioButtonLow.isChecked) {
            position = 0
        } else if (binding.radioButtonMedium.isChecked){
            position = 1
        }else {
            position = 2
        }
        return position
    }



}