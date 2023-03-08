package com.microservicio.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.demo.model.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
	List<Person> findByFirstNameContaining(String firstName);
		
	void deleteAll();
}
