package com.microservicio.demo.model.domain;

import java.time.LocalDate;

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
public class Person {
	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String street;
	
	private String city;
	
	private Integer postalCode;
	
	private LocalDate birthday;

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + ", postalCode=" + postalCode + ", birthday=" + birthday + "]";
	}
	
	
	
	
	
}
