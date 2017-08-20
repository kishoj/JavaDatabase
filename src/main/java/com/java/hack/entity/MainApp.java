package com.java.hack.entity;

public class MainApp {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		userDAO.save(new User("fn2", "ln2", "login2", "email2@gmail.com"));
		System.out.println("Entity saved.");
	}

}
