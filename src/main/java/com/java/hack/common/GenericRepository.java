package com.java.hack.common;

import java.util.List;
import java.util.Optional;

public interface GenericRepository <T, K> {
	List<T> findAll() throws Exception;
	Optional<T> findById(K id) throws Exception;
	T create(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	void deleteById(K id) throws Exception;
}
