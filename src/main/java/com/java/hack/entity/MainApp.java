package com.java.hack.entity;

public class MainApp {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();

		userDAO.findAll().forEach(user -> System.out.println(user.toString()));

		// INSERT
		User user = userDAO.save(new User("Boruto", "Uzumaki", "boruto", "naruto@gmail.com"));
		System.out.println(user.toString());

		// UPDATE
		user.setEmail("boruto@mail.com");
		userDAO.update(user);
		System.out.println(user.toString());

		// FIND BY USER ID
		System.out.println(userDAO.findOne(user.getId()).toString());

		// DELETE USER
		userDAO.delete(user);
		
		// Close connection
		userDAO.closeConnection();
	}

}
