package com.sayandas.firstproject.service;

import java.util.List;

import com.sayandas.firstproject.entity.Note;

public interface NoteService {

	public void saveNote(Note note);
	
	public List<Note> getNotes();
	
	public Note getNoteById(long noteId);
	
	public void updateNote(Note note);
	
	public void deleteNoteById(long noteId);
	
}
