package com.capgemini.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.person.exception.PersonNotFoundException;
import com.capgemini.person.model.Person;
import com.capgemini.person.service.PersonService;

@RestController
public class PersonController {

	
	@Autowired
	private PersonService service;

	@PostMapping("/new")
	public String addNewAccount(@RequestBody Person person) {
		service.add(person);
		return "Added Successful";
	}

	@GetMapping("/person/{id}")
	public String display(@PathVariable int id) {
		
		try {
			Person p2 =  service.getByPersonId(id);
			return p2.toString();
		} catch (PersonNotFoundException e) {
			
			e.printStackTrace();
			return e.getMessage();
		}	
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		
		try {
			service.deleteById(id);
			return "deleted successfully";
			
		} catch (PersonNotFoundException e) {
			
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
}
