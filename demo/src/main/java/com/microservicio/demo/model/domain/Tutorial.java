package com.microservicio.demo.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "tutorials")
public class Tutorial {
	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private boolean published;

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", published=" + published
				+ "]";
	}
	
	
}
