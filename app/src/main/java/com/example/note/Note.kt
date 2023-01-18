package com.example.note

class Note(id: Int, text: String, priorty: Int) {

    private val id: Int = id
    private val text:String = text
    private val priorty: Int = priorty

    fun getId(): Int {
        return id
    }

    fun getText(): String {
        return text
    }

    fun getPriorty(): Int{
        return priorty
    }

}