package com.java.hack.dto;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.java.hack.common.User;

public class UserConverter implements Converter <UserDTO, User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5932751713550101545L;
	
	public UserConverter() {
		
	}

	@Override
	public UserDTO convertToDTO(User entity) {
		UserDTO userDTO = null;
		if (entity != null) {
			userDTO = new UserDTO();
			userDTO.setAddtionalField(entity.toString());
			try {
				BeanUtils.copyProperties(userDTO, entity);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return userDTO;
	}

	@Override
	public User convertTOEntity(UserDTO dto) {
		User user = null;
		if (dto != null) {
			user = new User();
			try {
				BeanUtils.copyProperties(user, dto);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
