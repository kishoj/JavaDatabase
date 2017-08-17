package com.java.hack.gateway.rowdata;

import java.util.List;

import com.java.hack.common.User;

public interface UserFinder {
	List<User> findAll() throws Exception;
	User findById(Long userId) throws Exception;
}
