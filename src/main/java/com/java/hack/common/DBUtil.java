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
	private static RowMapper<Person> rowMapperForPerson;
	
	public static Connection getConnection(Database database) {
		Connection conn = null;
		try {
			switch (database) {
				case MYSQL:
					Class.forName(MySQLDBConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(MySQLDBConnection.URL, MySQLDBConnection.USERNAME, MySQLDBConnection.PASSWORD);	
					break;
				case POSTGRESQL:
					Class.forName(PostgreSQLDBConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(PostgreSQLDBConnection.URL, PostgreSQLDBConnection.USERNAME, PostgreSQLDBConnection.PASSWORD);	
					break;
			}
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
	
	public static Optional<Person> getPersonById(Connection connection, Long userId) throws SQLException {
		String sqlQuery = "SELECT id, firstname, lastname, login, email FROM person WHERE id = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setLong(1, userId);
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			rowMapperForPerson = MapperUtil::mapResultSetToPerson;
			return Optional.of(rowMapperForPerson.mapRow(rs));
		}		
		return Optional.empty();		
	}

	public static void updatePerson(Connection connection, Person person) throws SQLException {
		String sqlQuery = "UPDATE person SET firstname = ?, lastname = ?, login = ?, email = ? WHERE id = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, person.getFirstName());
		dbStatement.setString(2, person.getLastName());
		dbStatement.setString(3, person.getLogin());
		dbStatement.setString(4, person.getEmail());
		dbStatement.setLong(5, person.getId());
		dbStatement.executeUpdate();
	}

	public static Person insertPerson(Connection connection, Person person) throws SQLException {
		String sqlQuery = "INSERT INTO person (firstname, lastname, login, email) VALUES (?, ?, ?, ?)";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		dbStatement.setString(1, person.getFirstName());
		dbStatement.setString(2, person.getLastName());
		dbStatement.setString(3, person.getLogin());
		dbStatement.setString(4, person.getEmail());
		dbStatement.executeUpdate();
		ResultSet rs = dbStatement.getGeneratedKeys();
		if (rs.next()) {
			person.setId(rs.getLong(1));
		}
		return person;
	}

	public static void deletePerson(Connection connection, Person person) throws SQLException {
		String sqlQuery = "DELETE FROM person WHERE id = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setLong(1, person.getId());
		dbStatement.executeUpdate();
	}

	public static void deletePersonById(Connection connection, Long personId) throws SQLException {
		String sqlQuery = "DELETE FROM person WHERE id = ?";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		dbStatement.setString(1, personId.toString());
		dbStatement.executeUpdate();
	}

	public static List<Person> getAllPersons(Connection connection) throws SQLException {
		List<Person> persons = new ArrayList<>();
		String sqlQuery = "SELECT id, firstname, lastname, login, email FROM person";
		PreparedStatement dbStatement = connection.prepareStatement(sqlQuery);
		ResultSet rs = dbStatement.executeQuery();
		while (rs.next()) {
			rowMapperForPerson = MapperUtil::mapResultSetToPerson;
			persons.add(rowMapperForPerson.mapRow(rs));
		}		
		return persons;	
	}
	
}
