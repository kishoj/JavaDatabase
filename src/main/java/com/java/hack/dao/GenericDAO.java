package com.java.hack.dao;

import java.util.List;

public interface GenericDAO<T, K> {
	public List<T> getAll() throws Exception;
	public T getById(K id) throws Exception;
	public T create(T t) throws Exception;
	public void update(T t) throws Exception;
	public void delete(T t) throws Exception;
	public void deleteById(K id) throws Exception;
}
