package com.java.hack.activerecords;

public class App {

	public static void main(String[] args) throws Throwable {
		User.all().forEach(user -> System.out.println(user.toString()));
		
		User user = User.newRecord();
		user.setFirstName("Sasuke");
		user.setLastName("Uchiha");
		user.setEmail("sasuke@gmail.com");
		user.setLogin("Uchiha");
		user = user.create();		
		System.out.println(user.toString());
		
		user.setLogin("Sasuke");
		user.update();
		System.out.println(user.toString());
		
		System.out.println(User.findById(user.getId()).toString());
		
		user.delete();
		
		user.finalize();
	}
}
