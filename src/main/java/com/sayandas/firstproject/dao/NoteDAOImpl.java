package com.sayandas.firstproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sayandas.firstproject.entity.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
	}

	@Override
	public List<Note> getNotes() {
		List<Note> notes;
		
		// Get Hibernate Session
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve Notes from the Database
		Query<Note> getNotesQuery = session.createQuery("from Note order by created_at desc", Note.class);
		
		notes = getNotesQuery.getResultList();
				
		// return List
		return notes;
	}

	@Override
	public Note getNoteById(long noteId) {
		
		Note note;
		
		// Get Hibernate Session
		Session session = sessionFactory.getCurrentSession();
		
		// Query Database for Particular Note ( by Id )
		note = session.get(Note.class, noteId);
		
		// Return Note
		return note;
	}

	@Override
	public void deleteNote(long noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note noteToBeDeleted = session.get(Note.class, noteId);
		session.delete(noteToBeDeleted);
	}

}
