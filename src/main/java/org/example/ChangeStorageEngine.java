package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeStorageEngine {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://127.0.0.1:3306/csvtodb";
        String username = "root";
        String password = "123456789";

        // Table and desired storage engine
        String tableName = "testdb";
        String desiredStorageEngine = "InnoDB"; // Change this to the desired storage engine

        // SQL command to alter table's storage engine
        String sql = "ALTER TABLE " + tableName + " ENGINE = " + desiredStorageEngine;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Execute the SQL command
            statement.executeUpdate(sql);
            System.out.println("Table storage engine changed successfully.");

        } catch (SQLException e) {
            System.err.println("Error changing table storage engine: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
