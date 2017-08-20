package com.java.hack.dao;

import java.sql.Connection;
import java.util.List;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Database;
import com.java.hack.common.User;

public class UserDAOImpl implements UserDAO {
	
	Connection connection = null;
	
	public UserDAOImpl() {
		connection = DBUtil.getConnection(Database.MYSQL);
	}

	@Override
	public List<User> getAll() throws Exception {
		return DBUtil.getAllUsers(connection);
	}

	@Override
	public User getById(Long userId) throws Exception {
		return DBUtil.getUserById(connection, userId)
					.orElse(null);
	}

	@Override
	public User create(User user) throws Exception {
		return DBUtil.insertUser(connection, user);
	}
	
	@Override
	public void update(User user) throws Exception {
		DBUtil.updateUser(connection, user);
	}

	@Override
	public void delete(User user) throws Exception {
		DBUtil.deleteUser(connection, user);
	}

	@Override
	public void deleteById(Long userId) throws Exception {
		DBUtil.deleteUserById(connection, userId);
	}	

	public void finalize() throws Throwable {
		System.out.println("Database connection is closing");
		connection.close();
		connection = null;
	}
}
