package com.microservicio.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservicio.demo.model.PersonDto;
import com.microservicio.demo.model.domain.Person;
import com.microservicio.demo.repository.PersonRepository;
import com.microservicio.demo.service.PersonService;
import com.microservicio.demo.util.PersonMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service 
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository repository;
	
	private final PersonMapper mapper;
	
	@Override
	public List<PersonDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	public List<PersonDto> getAllByName(String name) {
		return repository.findByFirstNameContaining(name).stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	public PersonDto getById(String id) {
		return mapper.toDto(repository.findById(id).orElse(null));
	}
	

	@Override
	public PersonDto create(PersonDto person) {
		System.out.println(person.toString());
		System.out.println(mapper.toEntity(person).toString());
		return mapper.toDto(repository.save(mapper.toEntity(person)));
	}

	@Override
	public PersonDto update(String id, PersonDto person) {
		Person modificar = repository.findById(id).orElse(null);
		if(modificar == null) {
			return null;
		}else {
			modificar.setFirstName(person.getFirstName());
			modificar.setLastName(person.getLastName());
			modificar.setCity(person.getCity());
			modificar.setPostalCode(person.getPostalCode());
			modificar.setBirthday(person.getBirthday());
			modificar.setStreet(person.getStreet());
			return mapper.toDto(repository.save(modificar));
		}
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	






}
