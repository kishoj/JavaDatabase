package com.java.hack.common;

public class PostgreSQLDBConnection {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	public static final String URL = "jdbc:postgresql://localhost:5432/testdb";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "pass";
	public static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
}
