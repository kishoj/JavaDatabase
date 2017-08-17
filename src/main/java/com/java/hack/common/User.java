package com.java.hack.common;

public class User {
	
	protected Long id;
	protected String firstName;
	protected String lastName;
	protected String login;
	protected String email;
	
	public User() { }
	
	public User(String firstName, String lastName, String login, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setLogin(login);
		setEmail(email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login
				+ ", email=" + email + "]";
	}
	
}