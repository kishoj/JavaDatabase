package com.java.hack.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.hack.activerecords.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs) throws SQLException {
		User user = User.newRecord();
		user.setId(rs.getLong("ID"));
		user.setFirstName(rs.getString("FIRSTNAME"));
		user.setLastName(rs.getString("LASTNAME"));
		user.setLogin(rs.getString("LOGIN"));
		user.setEmail(rs.getString("EMAIL"));
		return user;
	}

}