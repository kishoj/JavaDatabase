package com.java.hack.service.cakepatterns;

import java.sql.SQLException;

import com.java.hack.common.Database;
import com.java.hack.common.Person;

public class MainApp {
	static class MySQLProfile implements UserServiceComponent, MySQLUserRepositoryComponent {

		public void disconnect() throws SQLException {
			connection.close();
		}
	}

	static class PostgreSQLProfile implements UserServiceComponent, PostgreSQLUserRepositoryComponent {
		
		public void disconnect() throws SQLException {
			connection.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		MySQLProfile mySQLProfile = new MySQLProfile();				
		UserService service = getUserServiceByDatabase(Database.MYSQL, mySQLProfile);
		databaseActionsForService(service);
		mySQLProfile.disconnect();

		PostgreSQLProfile postgreSQLProfile = new PostgreSQLProfile();		
		service = getUserServiceByDatabase(Database.POSTGRESQL, postgreSQLProfile);
		databaseActionsForService(service);
		postgreSQLProfile.disconnect();
	}

	private static void databaseActionsForService(UserService service) throws SQLException {
		// All Users
		service.findAll().forEach(user -> System.out.println(user.toString()));

		// INSERT
		Person person = service.create(new Person("Boruto", "Uzumaki", "boruto", "naruto@gmail.com"));
		System.out.println(person.toString());

		// UPDATE
		person.setEmail("boruto@mail.com");
		service.update(person);
		System.out.println(person.toString());

		// FIND BY USER ID
		System.out.println(service.findById(person.getId()).toString());
		System.out.println(person.toString());

		// DELETE USER
		service.delete(person);
	}

	private static UserService getUserServiceByDatabase(Database database, Object profile) {
		UserService userService = null;
		switch (database) {
			case MYSQL:
				userService = ((MySQLProfile) profile).getUserService();
				break;
			case POSTGRESQL:
				userService = ((PostgreSQLProfile) profile).getUserService();
				break;
		}
		return userService;
	}
}
