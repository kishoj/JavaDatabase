package com.java.hack.gateway.rowdata;

import com.java.hack.common.User;

public interface UserPersistor {
	User insert(User user) throws Exception;
	void update(User user) throws Exception;
	void delete(User user) throws Exception;
	void deleteById(Long userId) throws Exception;
}
