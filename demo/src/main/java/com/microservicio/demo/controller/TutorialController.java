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

import com.microservicio.demo.model.TutorialDto;
import com.microservicio.demo.service.TutorialService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
public class TutorialController {

	private final TutorialService service;

	
	@GetMapping("/tutorials")
	public ResponseEntity<?> getAllTutorials(){
		List<TutorialDto> result = service.getAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping("/tutorials/{title}")
	public ResponseEntity<?> getAllTutorialsByName(@PathVariable String title){
		List<TutorialDto> result = service.getAllByName(title);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping ("/tutorial/{id}")
	public ResponseEntity<?> getTutorial(@PathVariable String id){
		TutorialDto result = service.getById(id);
		if(result == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping("/tutorials/published")
	public ResponseEntity<?> getTutorialPublished(){
		List<TutorialDto> result = service.getByPublished(true);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	@PostMapping("/tutorials")
	public ResponseEntity<?> addTutorial(@RequestBody TutorialDto tutorial) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createTutorial(tutorial));
	}
	
	@PutMapping("tutorials/{id}")
	public ResponseEntity<?> updateTutorial(@PathVariable String id, @RequestBody TutorialDto tutorial){
		TutorialDto result = service.updateTutorial(id, tutorial);
		if(result == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<?> deleteTutorial(@PathVariable String id){
		service.deleteTutorial(id);
		return ResponseEntity.noContent().build();
	}
	
	
	// /all para no borrar sin querer
	@DeleteMapping("/tutorials/all")
	public ResponseEntity<?> deleteAllTutorials(){
		service.deleteAllTutorials();
		return ResponseEntity.noContent().build();
	}

}
