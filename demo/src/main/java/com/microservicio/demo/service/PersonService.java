package com.microservicio.demo.service;

import java.util.List;

import com.microservicio.demo.model.PersonDto;

public interface PersonService {
	
	public List<PersonDto> getAll();
	
	public PersonDto create(PersonDto person);
	
	public List<PersonDto> getAllByName(String name);
	
	public PersonDto getById(String id);
		
	public PersonDto update(String id, PersonDto person);
	
	public void delete(String id);
	
	public void deleteAll();

}
