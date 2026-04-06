package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/bank_management_system";
        String user = "postgres";
        String pass = "root";

        return DriverManager.getConnection(url, user, pass);
    }
}
