package com.java.hack.activerecords;

public interface ActiveRecord <T, K> {
	
	public T create() throws Exception;
	public void update() throws Exception;
	public void delete() throws Exception;
}