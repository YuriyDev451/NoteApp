package com.example.note

import android.nfc.Tag
import android.util.Log
import kotlin.random.Random

class Database {

     private var notes = ArrayList<Note>()

    companion object {
        val instance = Database()
    }


    constructor(){
        val random = Random
        for (i in 0..19) {
            val note = Note(i, "note" + i, random.nextInt(0, 3))
            notes.add(note)
        }
    }

    fun add (note: Note) {
        notes.add(note)
    }

    fun remove (id: Int) {
        for (i in 0 .. notes.size-2) {
            val note: Note = notes.get(i)
            if (note.getId()==id){
                notes.remove(note)
            }
        }
    }

    fun getNotes():ArrayList<Note> {
        return ArrayList(notes)
    }
}