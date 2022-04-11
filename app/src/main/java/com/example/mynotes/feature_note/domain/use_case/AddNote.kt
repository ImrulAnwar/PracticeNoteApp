package com.example.mynotes.feature_note.domain.use_case

import androidx.compose.runtime.referentialEqualityPolicy
import com.example.mynotes.feature_note.domain.model.InvalidNoteException
import com.example.mynotes.feature_note.domain.model.Note
import com.example.mynotes.feature_note.domain.repository.NoteRepository

class AddNote(
        private val noteRepository: NoteRepository
) {
        @Throws(InvalidNoteException::class)
        suspend operator fun invoke(note: Note) {
                if (note.title.isBlank()) {
                        throw InvalidNoteException("The title of the note can't be empty.")
                }
                if (note.title.isBlank()) {
                        throw InvalidNoteException("The content of the not can't be empty")
                }
                noteRepository.insertNote(note)
        }
}