package com.java.hack.gateway.rowdata;

import java.util.List;

import com.java.hack.common.User;

public class UserService implements UserFinder, UserPersistor {
	
	UserGateway userGateway = null;
	
	public UserService() {
		UserGateway.connect();
		userGateway = new UserGateway();
	}

	@Override
	public List<User> findAll() throws Exception {
		return UserGateway.all();
	}

	@Override
	public User findById(Long userId) throws Exception {
		return UserGateway.findById(userId);
	}
	
	@Override
	public User insert(User user) throws Exception {
		userGateway.setUser(user);
		return userGateway.create();
	}

	@Override
	public void update(User user) throws Exception {
		userGateway.setUser(user);
		userGateway.update();
	}

	@Override
	public void delete(User user) throws Exception {
		userGateway.setUser(user);
		userGateway.delete();
	}

	@Override
	public void deleteById(Long userId) throws Exception {
		UserGateway.deleteById(userId);
	}

	public void finalize() throws Throwable {
		System.out.println("Database connection is closing");
		UserGateway.disconnect();
		userGateway = null;
	}

}
