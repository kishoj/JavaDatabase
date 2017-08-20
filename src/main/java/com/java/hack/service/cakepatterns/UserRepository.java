package com.java.hack.service.cakepatterns;

import java.sql.SQLException;

import com.java.hack.common.GenericRepository;
import com.java.hack.common.Person;

public interface UserRepository extends GenericRepository<Person, Long> {
	
	String authenticate(String login, String email) throws SQLException;
}
