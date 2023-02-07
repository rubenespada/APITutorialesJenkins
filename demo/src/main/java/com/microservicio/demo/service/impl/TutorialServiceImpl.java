package com.microservicio.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservicio.demo.model.TutorialDto;
import com.microservicio.demo.model.domain.Tutorial;
import com.microservicio.demo.repository.TutorialRepository;
import com.microservicio.demo.service.TutorialService;
import com.microservicio.demo.util.TutorialMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service 
public class TutorialServiceImpl implements TutorialService{
	
	private final TutorialRepository repository;
	
	private final TutorialMapper mapper;
	
	@Override
	public List<TutorialDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	public List<TutorialDto> getAllByName(String name) {
		return repository.findByTitleContaining(name).stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	public TutorialDto getById(String id) {
		return mapper.toDto(repository.findById(id).orElse(null));
	}
	@Override
	public List<TutorialDto> getByPublished(boolean published) {
		return repository.findByPublished(published).stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public TutorialDto createTutorial(TutorialDto tutorial) {
		System.out.println(tutorial.toString());
		System.out.println(mapper.toEntity(tutorial).toString());
		return mapper.toDto(repository.save(mapper.toEntity(tutorial)));
	}

	@Override
	public TutorialDto updateTutorial(String id, TutorialDto tutorial) {
		Tutorial modificar = repository.findById(id).orElse(null);
		if(modificar == null) {
			return null;
		}else {
			modificar.setTitle(tutorial.getTitle());
			modificar.setDescription(tutorial.getDescription());
			modificar.setPublished(tutorial.isPublished());
			return mapper.toDto(repository.save(modificar));
		}
	}

	@Override
	public void deleteTutorial(String id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAllTutorials() {
		repository.deleteAll();
	}
	






}
