package com.example.mynotes.feature_note.domain.model

import com.example.mynotes.ui.theme.*

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity
data class Note(
        val title: String,
        val content: String,
        val timeStamp: Long,
        val color: Int,
        @PrimaryKey val id: Int? = null
) {
        companion object {
                val noteColors =
                        listOf(Color.Red, Color.Cyan, Color.Magenta, Color.Yellow, Color.White)
        }
}

class InvalidNoteException(message: String): Exception(message)