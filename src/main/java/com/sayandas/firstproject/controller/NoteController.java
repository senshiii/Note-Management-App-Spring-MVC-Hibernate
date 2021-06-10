package com.sayandas.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sayandas.firstproject.entity.Note;
import com.sayandas.firstproject.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	

	@GetMapping("/new")
	public String getNewNotePage(Model model) {
		Note note = new Note();
		model.addAttribute("note", note);
		return "notes/new-note";
	}
	
	@PostMapping("/new")
	public String postNewNotePage(@ModelAttribute Note newNote) {
		System.out.println("Form Data: " + newNote);
		noteService.saveNote(newNote);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		noteService.deleteNoteById(noteId);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateNote(Model model, @RequestParam("noteId") int noteId) {
		model.addAttribute("note", noteService.getNoteById(noteId));
		return "notes/update-note";
	}
	
	@PostMapping("/update")
	public String processUpdatedNote(@ModelAttribute Note updatedNote) {
		noteService.updateNote(updatedNote);
		return "redirect:/";
	}
	
	
	
	
}
