package com.java.hack.common;

public interface DBConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String URL = "jdbc:mysql://localhost:3306/TESTDB?useSSL=false&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
}
