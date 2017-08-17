package com.java.hack.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.java.hack.common.User;
import com.java.hack.dao.UserDAOImpl;

public class UserApplicationService {
	
	private UserDAOImpl userDao;
	private UserConverter converter;
	
	public UserApplicationService() {
		userDao = new UserDAOImpl();
		converter =  new UserConverter();
	}
	
	private UserDTO convertToDTO(User entity) {
		return converter.convertToDTO(entity);
	}
	
	private User convertToEntity(UserDTO userDTO) {
		return converter.convertTOEntity(userDTO);
	}
	
	public List<UserDTO> getUsers() throws Exception {
		return userDao.getAll().stream()
				.map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public UserDTO getUserById(Long userId) throws Exception {
		return convertToDTO(userDao.getById(userId));
	}
	
	public UserDTO createUser(UserDTO userDTO) throws Exception {
		return convertToDTO(userDao.create(convertToEntity(userDTO)));
	}
	
	public void updateUser(UserDTO userDTO) throws Exception {
		userDao.update(convertToEntity(userDTO));
	}
	
	public void deleteUser(UserDTO userDTO) throws Exception {
		userDao.delete(convertToEntity(userDTO));
	}
	
	public void deleteUserById(Long userId) throws Exception {
		userDao.deleteById(userId);
	}
	
	public void closeConnection() throws Throwable {
		userDao.finalize();
	}
}
