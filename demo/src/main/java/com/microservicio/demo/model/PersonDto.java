package com.microservicio.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {
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
		return "PersonDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + ", postalCode=" + postalCode + ", birthday=" + birthday + "]";
	}

	

}
