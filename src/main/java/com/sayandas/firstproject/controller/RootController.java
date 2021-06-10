package com.sayandas.firstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sayandas.firstproject.entity.Note;
import com.sayandas.firstproject.service.NoteService;

@Controller
@RequestMapping("/")
public class RootController {

	@Autowired
	NoteService noteService;
	
	public RootController() {
		System.out.println("\nRootController Constructor\n");
	}
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		List<Note> notes = noteService.getNotes();
//		System.out.println("\nAll Notes: \n");
//		for(Note n : notes)
//			System.out.println(n + "\n");
		model.addAttribute("notes", notes);
		return "home";
	}
	
}
