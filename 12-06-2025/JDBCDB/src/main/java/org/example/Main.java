package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcdb";
        String user = "root";
        String password = "Airtel@123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            String sql="INSERT INTO employee (id, name, age) VALUES (2, 'Mansi', 20);";
            conn.createStatement().executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}