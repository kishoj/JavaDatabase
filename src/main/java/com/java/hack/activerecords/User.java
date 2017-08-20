package com.java.hack.activerecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Database;
import com.java.hack.common.UserRowMapper;

public class User implements ActiveRecord <User, Long> {
	static Connection conn = null;
	static
	{
		conn = DBUtil.getConnection(Database.MYSQL);		
	};
	
	private Long id;
	private String firstName;
	private String lastName;
	private String login;
	private String email;
	
	private User() {
		if (conn == null) {
			conn = DBUtil.getConnection(Database.MYSQL);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public synchronized void update() throws Exception {
		String sqlQuery = "UPDATE USER SET FIRSTNAME= ?, LASTNAME = ?, LOGIN = ?, EMAIL = ? WHERE ID = ?";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		dbStatement.setString(1, firstName);
		dbStatement.setString(2, lastName);
		dbStatement.setString(3, login);
		dbStatement.setString(4, email);
		dbStatement.setString(5, id.toString());
		dbStatement.executeUpdate();
	}

	public synchronized User create() throws Exception {
		String sqlQuery = "INSERT INTO USER (FIRSTNAME, LASTNAME, LOGIN, EMAIL) VALUES (?, ?, ?, ?)";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		dbStatement.setString(1, firstName);
		dbStatement.setString(2, lastName);
		dbStatement.setString(3, login);
		dbStatement.setString(4, email);
		dbStatement.executeUpdate();
		ResultSet rs = dbStatement.getGeneratedKeys();
		if (rs.next()) {
		    setId(rs.getLong(1));
		}
		return this;
	}

	public static List<User> all() throws Exception {
		List<User> users = new ArrayList<>();
		String sqlQuery = "SELECT ID, FIRSTNAME, LASTNAME, LOGIN, EMAIL FROM USER";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			UserRowMapper userRowMapper = new UserRowMapper();
			users.add(userRowMapper.mapRow(rs));
		}		
		return users;
	}

	public static User findById(Long id) throws Exception {
		String sqlQuery = "SELECT ID, FIRSTNAME, LASTNAME, LOGIN, EMAIL FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		dbStatement.setString(1, id.toString());
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			UserRowMapper userRowMapper = new UserRowMapper();
			return userRowMapper.mapRow(rs);
		}		
		return null;
	}

	public static boolean exists(Long id) throws Exception {
		String sqlQuery = "SELECT EXISTS(SELECT * FROM USER WHERE ID = ?);";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		dbStatement.setString(1, id.toString());
		ResultSet rs = dbStatement.executeQuery();
		int value = rs.getInt(0);
		if (value == 1) return true;
		else return false;
	}

	public static User newRecord() {
		return new User();
	}

	public synchronized void delete() throws Exception {
		String sqlQuery = "DELETE FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		dbStatement.setString(1, id.toString());
		dbStatement.executeUpdate();
	}
	
	public static synchronized void deleteById(Long userId) throws Exception {
		String sqlQuery = "DELETE FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = conn.prepareStatement(sqlQuery);
		dbStatement.setString(1, userId.toString());
		dbStatement.executeUpdate();
	}
	
	public void finalize() throws Throwable {
		System.out.println("Database connection is closing");
	    conn.close();
	    conn = null;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login
				+ ", email=" + email + "]";
	}	
	
}