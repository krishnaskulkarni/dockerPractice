package com.capgemini.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.person.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{

}
