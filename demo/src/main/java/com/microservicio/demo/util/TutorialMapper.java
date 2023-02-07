package com.microservicio.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.microservicio.demo.model.TutorialDto;
import com.microservicio.demo.model.domain.Tutorial;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TutorialMapper {
	private final ModelMapper modelMapper;
	
	public TutorialDto toDto(Tutorial tutorial) {
		return modelMapper.map(tutorial, TutorialDto.class);
	}
	public Tutorial toEntity(TutorialDto tutorialDto) {
		return modelMapper.map(tutorialDto, Tutorial.class);
	}

}
