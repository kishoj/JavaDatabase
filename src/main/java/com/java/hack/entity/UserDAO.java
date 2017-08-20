package com.java.hack.entity;

public class UserDAO extends CrudDAO<User, Long> {

	public UserDAO() {
		super(User.class);
		this.entityManager = JPAUtility.getEntityManager();
	}
	
	public void closeConnection() {
		JPAUtility.close();
	}
	
}
