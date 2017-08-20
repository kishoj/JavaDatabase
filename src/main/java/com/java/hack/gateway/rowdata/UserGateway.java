package com.java.hack.gateway.rowdata;

import java.sql.Connection;
import java.util.List;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Database;
import com.java.hack.common.User;

public class UserGateway extends User {
	
	private static Connection connection = null;	
	
	public static void connect() {
		System.out.println("Connecting to Database ...");
		connection = DBUtil.getConnection(Database.MYSQL);
	}
	
	public static void disconnect() throws Exception {
		System.out.println("Database connection closed ...");
		connection.close();
		connection = null;
	}
	
	public UserGateway() { }
	
	public synchronized static List<User> all() throws Exception {
		return DBUtil.getAllUsers(connection);			
	}
	
	public synchronized static User findById(Long userId) throws Exception {
		return DBUtil.getUserById(connection, userId)
					.orElse(null);	
	}
	
	public synchronized void update() throws Exception {
		DBUtil.updateUser(connection, this);
	}
	
	public synchronized User create() throws Exception {
		return DBUtil.insertUser(connection, this);
	}
	
	public synchronized void delete() throws Exception {
		DBUtil.deleteUser(connection, this);
	}
	
	public synchronized static void deleteById(Long userId) throws Exception {
		DBUtil.deleteUserById(connection, userId);
	}

	public void setUser(User user) {
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setLogin(user.getLogin());
		setEmail(user.getEmail());
		setId(user.getId());
	}
}
