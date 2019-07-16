package com.capgemini.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.person.dao.PersonDao;
import com.capgemini.person.exception.PersonNotFoundException;
import com.capgemini.person.model.Person;
import com.capgemini.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;
	
	@Override
	public void add(Person person) {
		dao.save(person);
	}

	@Override
	public Person getByPersonId(int id) throws PersonNotFoundException {
		try
		{
		Person p1 = dao.findById(id).get();
		return p1;
		}
		catch(Exception e){
			throw new PersonNotFoundException("Person not found");
		}

		
	}

	@Override
	public void deleteById(int id) throws PersonNotFoundException {
		try {
		dao.deleteById(id);		
		}
		catch(Exception e) {
			throw new PersonNotFoundException("person does not exist");
		}
	}
}
