// package com.example.demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;// 3306

    public Connection getConnection(){
        String databaseName = "midterm";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost:3309/"+databaseName;
        try{
        //    Class.forName("mysql.jdbc.Driver");

            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
