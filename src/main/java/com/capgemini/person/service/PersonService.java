package com.capgemini.person.service;

import com.capgemini.person.exception.PersonNotFoundException;
import com.capgemini.person.model.Person;

public interface PersonService {

	public void add(Person person);

	public Person getByPersonId(int id) throws PersonNotFoundException;
	
	public void deleteById(int id) throws PersonNotFoundException;
}
