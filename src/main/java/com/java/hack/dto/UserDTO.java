package com.java.hack.dto;

import java.io.Serializable;

import com.java.hack.common.User;

public class UserDTO extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2660434543228456222L;
	
	private String addtionalField;

	public UserDTO() { 
		
	}
	
	public UserDTO(User user) { 
		copyPropterties(user);
	}

	private void copyPropterties(User user) {
		setId(user.getId());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setLogin(user.getLogin());
		setEmail(user.getEmail());
	}

	public String getAddtionalField() {
		return addtionalField;
	}

	public void setAddtionalField(String addtionalField) {
		this.addtionalField = addtionalField;
	}

	@Override
	public String toString() {
		return "UserDTO [addtionalField=" + addtionalField + ", id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", login=" + login + ", email=" + email + "]";
	}		
	
}
