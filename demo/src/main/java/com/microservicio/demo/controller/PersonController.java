package com.microservicio.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.demo.model.PersonDto;
import com.microservicio.demo.service.PersonService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
public class PersonController {

	private final PersonService service;

	@GetMapping("/persons")
	public ResponseEntity<?> getAllPersons() {
		List<PersonDto> result = service.getAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping("/persons/{firstName}")
	public ResponseEntity<?> getAllPersonsByName(@PathVariable String firstName) {
		List<PersonDto> result = service.getAllByName(firstName);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<?> getPerson(@PathVariable String id) {
		PersonDto result = service.getById(id);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/persons")
	public ResponseEntity<?> addPerson(@RequestBody PersonDto person) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(person));
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<?> updatePerson(@PathVariable String id, @RequestBody PersonDto person) {
		PersonDto result = service.update(id, person);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// /all para no borrar sin querer
	@DeleteMapping("/persons/all")
	public ResponseEntity<?> deleteAllPersons() {
		service.deleteAll();
		return ResponseEntity.noContent().build();
	}

}
