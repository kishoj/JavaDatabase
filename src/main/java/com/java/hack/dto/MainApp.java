package com.java.hack.dto;

import com.java.hack.common.User;

public class MainApp {

	public static void main(String[] args) throws Throwable {
		UserApplicationService appService = new UserApplicationService();
		appService.getUsers().forEach(userDTO -> System.out.println(userDTO.toString()));

		// INSERT
		UserDTO userDTO = new UserDTO(new User("Harry", "Potter", "harry", "porter@gmail.com"));
		userDTO = appService.createUser(userDTO);
		System.out.println(userDTO.toString());

		// UPDATE
		userDTO.setEmail("harry_potter@gmail.com");
		appService.updateUser(userDTO);
		System.out.println(userDTO.toString());

		// FIND BY USER ID
		System.out.println(appService.getUserById(userDTO.getId()).toString());

		// DELETE USER
		appService.deleteUser(userDTO);

		appService.closeConnection();
	}

}
