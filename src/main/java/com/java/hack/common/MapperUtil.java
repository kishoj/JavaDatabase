package com.java.hack.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.hack.common.User;

public class MapperUtil {
	public static User mapResultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setFirstName(rs.getString("FIRSTNAME"));
		user.setLastName(rs.getString("LASTNAME"));
		user.setLogin(rs.getString("LOGIN"));
		user.setEmail(rs.getString("EMAIL"));
		return user;
	}
}
