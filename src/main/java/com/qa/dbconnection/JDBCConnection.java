package com.qa.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

		private final String dbUrl;

		private final String dbUser;

		private final String dbPassword;
		
		private JDBCConnection() {
			super();
			this.dbUrl = "jdbc:mysql://127.0.0.1:3306/animal";
			this.dbUser = "root";
			this.dbPassword = "root";
		}

		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		}

		private static JDBCConnection instance;

		public static JDBCConnection getInstance() {
			if (instance == null) {
				instance = new JDBCConnection();
			}
			return instance;
		}
	
	
	
	
}
