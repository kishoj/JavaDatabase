package com.java.hack.service.cakepatterns;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.java.hack.common.Person;

public class UserService {
	private final UserRepository repository;

	UserService(UserRepository repository) {
		this.repository = repository;
	}

	String authenticate(String login, String email) throws SQLException {
		return repository.authenticate(login, email);
	}
	
	public List<Person> findAll() throws SQLException {
		return repository.findAll();
	}
	
	Optional<Person> findById(Long id) throws SQLException {
		return repository.findById(id);
	}
	
	Person create(Person user) throws SQLException {
		return repository.create(user);
	}
	
	void update(Person user) throws SQLException {
		repository.update(user);
	}
	
	void delete(Person user) throws SQLException {
		repository.delete(user);
	}
	
	void deleteById(Long id) throws SQLException {
		repository.deleteById(id);
	}
	
}
