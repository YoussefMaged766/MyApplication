package com.example.myapplication

import androidx.compose.runtime.mutableStateOf
import com.example.myapplication.ui.Note

class Util{
    companion object{
        val note = mutableStateOf(listOf<Note>())
    }
}