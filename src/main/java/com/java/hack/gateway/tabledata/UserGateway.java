package com.java.hack.gateway.tabledata;

import java.sql.Connection;

import com.java.hack.common.DBUtil;
import com.java.hack.common.User;

public class UserGateway {
	
	private static Connection connection = null;	
	
	public static void connect() {
		System.out.println("Connecting to Database ...");
		connection = DBUtil.getConnection();
	}
	
	public static void disconnect() throws Exception {
		System.out.println("Database connection closed ...");
		connection.close();
		connection = null;
	}
			
	public UserGateway() { }

	public synchronized static User findById(Long userId) throws Exception {
		return DBUtil.getUserById(connection, userId).orElse(null);
	}
	
	public synchronized static User update(Long id, String firstName, String lastName, String login, String email) throws Exception {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setEmail(email);		
		DBUtil.updateUser(connection, user);
		return user;
	}
	
	public synchronized static User create(String firstName, String lastName, String login, String email) throws Exception {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setEmail(email);		
		return DBUtil.insertUser(connection, user);
	}
	
	public synchronized static void deleteById(Long userId) throws Exception {
		DBUtil.deleteUserById(connection, userId);
	}
	
}
