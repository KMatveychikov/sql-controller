package com.example.sqlcontroller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private Connection connection;
    private DriverManager driverManager;


    public Connection getConnection() {
        return connection;
    }

    public DBWorker(String URL){
        try {
            connection = driverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
