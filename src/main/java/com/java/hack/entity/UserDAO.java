package com.java.hack.entity;

public class UserDAO extends CrudDAO<User, Long> {

	public UserDAO() {
		super(User.class);
		this.entityManager = HibernateUtility.getEntityManager();
	}
	
	public void closeConnection() {
		HibernateUtility.close();
	}
	
}
