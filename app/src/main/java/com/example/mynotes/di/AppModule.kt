package com.example.mynotes.di

import android.app.Application
import androidx.room.Room
import com.example.mynotes.feature_note.data.data_source.NoteDatabase
import com.example.mynotes.feature_note.data.repository.NoteRepositoryImplementation
import com.example.mynotes.feature_note.domain.repository.NoteRepository
import com.example.mynotes.feature_note.domain.use_case.AddNote
import com.example.mynotes.feature_note.domain.use_case.DeleteNotes
import com.example.mynotes.feature_note.domain.use_case.GetNotes
import com.example.mynotes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
        @Provides
        @Singleton
        fun provideNoteDatabase(app: Application):NoteDatabase{
                return Room.databaseBuilder(
                        app, NoteDatabase:: class.java,NoteDatabase.DATABASE_NAME
                ).build()
        }

        @Provides
        @Singleton
        fun provideNoteRepository(database: NoteDatabase): NoteRepository {
                return NoteRepositoryImplementation(database.noteDao)
        }

        @Provides
        @Singleton
        fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
                return NoteUseCases(
                        getNotes = GetNotes(repository),
                        deleteNotes = DeleteNotes(repository),
                        addNotes = AddNote(repository)
                )
        }
}