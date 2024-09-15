package com.ashutosh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import com.ashutosh.constant.DBConstant;

public class GetConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DBConstant.DB_URL, DBConstant.USER,DBConstant.PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
