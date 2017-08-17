package com.java.hack.gateway.rowdata;

import com.java.hack.common.User;

public class MainApp {

	public static void main(String[] args) throws Throwable {
		UserService userService = new UserService();

		UserGateway.all().forEach(user -> System.out.println(user.toString()));

		// INSERT
		User user = new User("Boruto", "Uzumaki", "boruto", "naruto@gmail.com");
		user = userService.insert(user);
		System.out.println(user.toString());

		// UPDATE
		user.setEmail("boruto@mail.com");
		userService.update(user);
		System.out.println(user.toString());

		// FIND BY USER ID
		System.out.println(userService.findById(user.getId()).toString());

		// DELETE USER
		userService.delete(user);

		userService.finalize();
	}

}
