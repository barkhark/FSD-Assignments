package com.lab.a6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Utility class to obtain a JDBC connection to MySQL. */
public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/library_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "root";
    private static final String PASSWORD = "Barkha@123"; // change to your MySQL root password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found. Add mysql-connector-j jar to WEB-INF/lib.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
