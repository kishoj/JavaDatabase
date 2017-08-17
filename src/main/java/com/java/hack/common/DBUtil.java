package com.java.hack.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBUtil {
	
	private static RowMapper<User> rowMapper;
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBConnection.URL, DBConnection.USERNAME, DBConnection.PASSWORD);	
			if (Optional.ofNullable(conn).isPresent()) {
				System.out.println("Connected to Database ...");
			}
		} catch (SQLException e) {
			try {
				throw new Exception("Error occured connecting dagtabase", e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Optional<User> getUserById(Connection connection, Long userId) throws SQLException {
		String sqlQuery = "SELECT ID, FIRSTNAME, LASTNAME, LOGIN, EMAIL FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, userId.toString());
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			rowMapper = MapperUtil::mapResultSetToUser;
			return Optional.of(rowMapper.mapRow(rs));
		}		
		return Optional.empty();		
	}

	public static void updateUser(Connection connection, User user) throws SQLException {
		String sqlQuery = "UPDATE USER SET FIRSTNAME= ?, LASTNAME = ?, LOGIN = ?, EMAIL = ? WHERE ID = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, user.getFirstName());
		dbStatement.setString(2, user.getLastName());
		dbStatement.setString(3, user.getLogin());
		dbStatement.setString(4, user.getEmail());
		dbStatement.setString(5, user.getId().toString());
		dbStatement.executeUpdate();
	}

	public static User insertUser(Connection connection, User user) throws SQLException {
		String sqlQuery = "INSERT INTO USER (FIRSTNAME, LASTNAME, LOGIN, EMAIL) VALUES (?, ?, ?, ?)";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		dbStatement.setString(1, user.getFirstName());
		dbStatement.setString(2, user.getLastName());
		dbStatement.setString(3, user.getLogin());
		dbStatement.setString(4, user.getEmail());
		dbStatement.executeUpdate();
		ResultSet rs = dbStatement.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getLong(1));
		}
		return user;
	}

	public static void deleteUser(Connection connection, User user) throws SQLException {
		String sqlQuery = "DELETE FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, user.getId().toString());
		dbStatement.executeUpdate();
	}

	public static void deleteUserById(Connection connection, Long userId) throws SQLException {
		String sqlQuery = "DELETE FROM USER WHERE ID = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, userId.toString());
		dbStatement.executeUpdate();
	}

	public static List<User> getAllUsers(Connection connection) throws SQLException {
		List<User> users = new ArrayList<>();
		String sqlQuery = "SELECT ID, FIRSTNAME, LASTNAME, LOGIN, EMAIL FROM USER";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			rowMapper = MapperUtil::mapResultSetToUser;
			users.add(rowMapper.mapRow(rs));
		}		
		return users;	
	}
	
}
