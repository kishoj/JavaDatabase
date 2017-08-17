package com.java.hack.gateway.tabledata;

import com.java.hack.common.User;

public class MainApp {

	public static void main(String[] args) throws Exception {
		UserGateway.connect();		
		
		// INSERT
		User user = UserGateway.create("Ram", "Kasula", "ram", "ram@gmail.com");
		System.out.println(user.toString());
				
		// UPDATE
		user = UserGateway.update(user.getId(), "Ram", "Kasula", "ram123", "ram_paju@mail.com");
		System.out.println(user.toString());
				
		// FIND BY USER ID
		System.out.println(UserGateway.findById(user.getId()).toString());
				
		// DELETE USER
		UserGateway.deleteById(user.getId());
		
		UserGateway.disconnect();
	}

}
