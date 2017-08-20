package com.java.hack.common;

public class Person extends User {
	
	public Person() { }
	
	public Person(String firstName, String lastName, String login, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setLogin(login);
		setEmail(email);
	}

	@Override
	public String toString() {
		return "Person [getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getLogin()=" + getLogin() + ", getEmail()=" + getEmail() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}	
	
}
