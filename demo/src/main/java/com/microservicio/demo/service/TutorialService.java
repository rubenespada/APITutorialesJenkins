package com.microservicio.demo.service;

import java.util.List;

import com.microservicio.demo.model.TutorialDto;

public interface TutorialService {
	
	public List<TutorialDto> getAll();
	
	public TutorialDto createTutorial(TutorialDto tutorial);
	
	public List<TutorialDto> getAllByName(String name);
	
	public TutorialDto getById(String id);
	
	public List<TutorialDto> getByPublished(boolean published);
	
	public TutorialDto updateTutorial(String id, TutorialDto tutorial);
	
	public void deleteTutorial(String id);
	
	public void deleteAllTutorials();

}
