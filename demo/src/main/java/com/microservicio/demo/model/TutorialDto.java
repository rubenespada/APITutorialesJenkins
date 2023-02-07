package com.microservicio.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TutorialDto {
	private String id;

	private String title;

	private String description;

	private boolean published;

	@Override
	public String toString() {
		return "TutorialDto [id=" + id + ", title=" + title + ", description=" + description + ", published="
				+ published + "]";
	}

}
