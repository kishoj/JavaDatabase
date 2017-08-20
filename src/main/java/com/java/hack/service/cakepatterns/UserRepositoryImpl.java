package com.java.hack.service.cakepatterns;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Person;

public class UserRepositoryImpl implements UserRepository {
	
	private Connection connection;
	
	public UserRepositoryImpl(Connection connection) {
		this.connection = connection;
	}
	
	public void disconnect() throws Exception {
		this.connection.close();
		this.connection = null;
	}

	@Override
	public Optional<Person> findById(Long personId) throws SQLException {
		return DBUtil.getPersonById(connection, personId);
	}

	@Override
	public Person create(Person Person) throws SQLException {
		return DBUtil.insertPerson(connection, Person);
	}

	@Override
	public void update(Person Person) throws SQLException {
		DBUtil.updatePerson(connection, Person);
	}

	@Override
	public void delete(Person Person) throws SQLException {
		DBUtil.deletePerson(connection, Person);
	}

	@Override
	public void deleteById(Long personId) throws SQLException {
		DBUtil.deletePersonById(connection, personId);
	}

	@Override
	public String authenticate(String login, String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() throws SQLException {
		return DBUtil.getAllPersons(connection);
	}

}
