package com.java.hack.service.cakepatterns;

import java.sql.Connection;
import java.sql.SQLException;

import com.java.hack.common.DBUtil;
import com.java.hack.common.Database;

public interface PostgreSQLUserRepositoryComponent extends UserRepositoryComponent {
	static Connection connection = DBUtil.getConnection(Database.POSTGRESQL);
	
	default UserRepository getUserRepository() {
        return new UserRepositoryImpl(connection);
    }
	
	default void disconnect() throws SQLException {
		connection.close();
	}
}
