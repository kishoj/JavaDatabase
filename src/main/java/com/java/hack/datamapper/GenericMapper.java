package com.java.hack.datamapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Database;

public interface GenericMapper<T> {
	Optional<T> findById(Long id) throws SQLException;
	T insert(T t) throws SQLException;
	void update(T t) throws SQLException;
	void delete(T t) throws SQLException;
	void deleteById(Long id) throws SQLException;
	
	default Connection connection() {
		return DBUtil.getConnection(Database.MYSQL);
	}
}
