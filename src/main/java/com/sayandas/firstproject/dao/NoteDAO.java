package com.sayandas.firstproject.dao;

import java.util.List;

import com.sayandas.firstproject.entity.Note;

public interface NoteDAO {
	
	public void saveNote(Note note);
	
	public List<Note> getNotes();
	
	public Note getNoteById(long noteId);
		
	public void deleteNote(long noteId);
	
}
