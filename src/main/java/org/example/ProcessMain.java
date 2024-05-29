package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProcessMain {


    // Necessary information for database connection
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root/csvtodb"; // Use the IP address of the database server instead of localhost if needed

    // Database username and password
    static final String USER = "root";
    static final String PASS = "123456789";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establishing connection to the database
            System.out.println("Connecting to the database...");
            conn = getConnection();

            // Connection successful message
            System.out.println("Database connection successful.");
        } catch (SQLException se) {
            // Catching JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Catching other errors
            e.printStackTrace();
        } finally {
            // Closing the connection
            closeConnection(conn);
        }
    }

    public static Connection getConnection() throws SQLException {
        // Loading the JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        // Establishing connection to the database
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void closeConnection(Connection conn) {
        try {
            // Closing the connection
            if (conn != null)
                conn.close();
            System.out.println("Database connection closed.");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
