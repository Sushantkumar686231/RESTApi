package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JournalEntity;

@RestController
@RequestMapping("/journal")
public class JournalController {

	private Map<Long,JournalEntity> journalentries=new HashMap<Long, JournalEntity>();
	
	@GetMapping("/getAll")
	public List<JournalEntity> getAllJoutnals(){
		return new ArrayList<>(journalentries.values());
	}	
	
	
	@PostMapping("/createUser")
	public boolean createJournals(@RequestBody JournalEntity journal) {
		journalentries.put(journal.getId(), journal);
		return true;
	}
	
	@DeleteMapping("/{id}")
	public String deleteJournalById(@PathVariable Long id)
	{
		journalentries.remove(id);
		return "Succefully deleted the user";
	}
	
	@PutMapping("/{id}")
	public JournalEntity updateData(@RequestBody JournalEntity journal, @PathVariable Long id)
	{
		return journalentries.put(id, journal);
		
	}
}
	

