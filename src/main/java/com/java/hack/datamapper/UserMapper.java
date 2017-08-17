package com.java.hack.datamapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.java.hack.common.DBUtil;
import com.java.hack.common.User;

public class UserMapper implements GenericMapper<User> {
	
	private Connection connection = null;
	
	public UserMapper() { 
		this.connection = connection();
	}

	@Override
	public Optional<User> findById(Long userId) throws SQLException {
		return DBUtil.getUserById(connection, userId);			
	}

	@Override
	public synchronized User insert(User user) throws SQLException{
		return DBUtil.insertUser(connection, user);
	}

	@Override
	public synchronized void update(User user) throws SQLException {
		DBUtil.updateUser(connection, user);
	}

	@Override
	public synchronized void delete(User user) throws SQLException {
		DBUtil.deleteUser(connection, user);
	}

	@Override
	public synchronized void deleteById(Long id) throws SQLException {
		DBUtil.deleteUserById(connection, id);
	}
	
}
