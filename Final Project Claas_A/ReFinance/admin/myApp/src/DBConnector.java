// package com.example.demo;

import java.sql.*;
public class DBConnector {
    public static Connection getConnection() throws SQLException{
        // Class.forName("mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/midterm","root","");
        return connection; // 3306
    }
}
