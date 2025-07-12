package org.mz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() {
		// Database credentials
        String url = "jdbc:mysql://localhost:3306/product"; 
        String username = "root"; 
        String password = "Sudhu@6435";

        Connection conn = null;
       
            // Load MySQL JDBC Driver
            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       return conn;
	}

}
