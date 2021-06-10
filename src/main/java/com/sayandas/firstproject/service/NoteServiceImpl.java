package com.sayandas.firstproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sayandas.firstproject.dao.NoteDAO;
import com.sayandas.firstproject.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDAO noteDao;
	
	@Override
	@Transactional
	public void saveNote(Note note) {
		noteDao.saveNote(note);
	}

	@Override
	@Transactional
	public List<Note> getNotes() {
		return noteDao.getNotes();
	}

	@Override
	@Transactional
	public Note getNoteById(long noteId) {
		return noteDao.getNoteById(noteId);
	}

	@Override
	@Transactional
	public void updateNote(Note note) {
		noteDao.saveNote(note);
	}

	@Override
	@Transactional
	public void deleteNoteById(long noteId) {
		noteDao.deleteNote(noteId);
	}

}
