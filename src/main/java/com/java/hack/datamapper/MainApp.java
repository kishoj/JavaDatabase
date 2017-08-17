package com.java.hack.datamapper;

import java.sql.SQLException;

import com.java.hack.common.User;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		UserMapper mapper = new UserMapper();
		
		// INSERT
		User user = new User("Naruto", "Uzumaki", "naruto", "ninetail@gmail.com");
		user = mapper.insert(user);
		System.out.println(user.toString());
		
		// UPDATE
		user.setEmail("naruto@mail.com");
		mapper.update(user);		
		System.out.println(user.toString());
		
		// FIND BY USER ID
		mapper.findById(user.getId())
			.ifPresent(u -> System.out.println(u.toString()));	
		
		// DELETE USER
		mapper.delete(user);		
	}
	
}