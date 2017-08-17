package com.java.hack.dao;

import com.java.hack.common.User;

public class MainApp {

	public static void main(String[] args) throws Throwable {
		UserDAOImpl userDao = new UserDAOImpl();

		userDao.getAll().forEach(user -> System.out.println(user.toString()));

		// INSERT
		User user = new User("Ian", "Wilson", "ian", "ian_wilson@gmail.com");
		user = userDao.create(user);
		System.out.println(user.toString());

		// UPDATE
		user.setEmail("ian@mail.com");
		userDao.update(user);
		System.out.println(user.toString());

		// FIND BY USER ID
		System.out.println(userDao.getById(user.getId()).toString()); 
		
		// DELETE USER
		userDao.delete(user);
		
		userDao.finalize();
	}

}
