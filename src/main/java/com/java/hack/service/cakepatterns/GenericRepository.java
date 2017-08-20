package com.java.hack.service.cakepatterns;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericRepository <T> {
	List<T> findAll() throws SQLException;
	Optional<T> findById(Long id) throws SQLException;
	T create(T t) throws SQLException;
	void update(T t) throws SQLException;
	void delete(T t) throws SQLException;
	void deleteById(Long id) throws SQLException;
}
