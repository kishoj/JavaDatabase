package com.java.hack.service.cakepatterns;

import java.util.List;
import java.util.Optional;

import com.java.hack.common.Person;

public class UserService {
	
	private final UserRepository repository;

	UserService(UserRepository repository) {
		this.repository = repository;
	}

	String authenticate(String login, String email) throws Exception {
		return repository.authenticate(login, email);
	}
	
	public List<Person> findAll() throws Exception {
		return repository.findAll();
	}
	
	Optional<Person> findById(Long id) throws Exception {
		return repository.findById(id);
	}
	
	Person create(Person user) throws Exception {
		return repository.create(user);
	}
	
	void update(Person user) throws Exception {
		repository.update(user);
	}
	
	void delete(Person user) throws Exception {
		repository.delete(user);
	}
	
	void deleteById(Long id) throws Exception {
		repository.deleteById(id);
	}
	
}
