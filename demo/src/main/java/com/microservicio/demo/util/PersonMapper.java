package com.microservicio.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.microservicio.demo.model.PersonDto;
import com.microservicio.demo.model.domain.Person;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonMapper {
	private final ModelMapper modelMapper;
	
	public PersonDto toDto(Person tutorial) {
		return modelMapper.map(tutorial, PersonDto.class);
	}
	public Person toEntity(PersonDto tutorialDto) {
		return modelMapper.map(tutorialDto, Person.class);
	}

}
