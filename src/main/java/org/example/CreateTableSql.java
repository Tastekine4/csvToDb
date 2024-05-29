package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableSql {

    // Necessary information for database connection
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/csvtodb"; // Use the IP address of the database server instead of localhost if needed

    // Database username and password
    static final String USER = "root";
    static final String PASS = "123456789";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
//            String sql = "SET GLOBAL innodb_page_size = 32k";
//            stmt.executeUpdate(sql);

            // Sütun adlarını ve veri türlerini içeren SQL sorgusu oluşturuluyor
            StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE mytable (");
            for (int i = 1; i <= 64; i++) {
                // Sütun adları "column1", "column2", ... gibi olacak
                String columnName = "column" + i;
                // Her sütunun veri türü VARCHAR(255) olacak (örnek olarak)
                String columnDefinition = columnName + " VARCHAR(255)";

                // Sütun adı ve veri türü sorguya ekleniyor
                sqlBuilder.append(columnDefinition);

                // Son sütun değilse virgül ekleniyor
                if (i < 64) {
                    sqlBuilder.append(", ");
                }
            }
            // Tablo oluşturuluyor
            sqlBuilder.append(")");
            stmt.executeUpdate(sqlBuilder.toString());

            System.out.println("Table created successfully.");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
