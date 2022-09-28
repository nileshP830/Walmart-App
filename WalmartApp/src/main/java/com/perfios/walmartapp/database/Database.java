package com.perfios.walmartapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    Connection con=null;

    /*
     *  This method helps to connect with the database
     */
    public Connection getConnection() {

        String databaseUrl = "jdbc:mysql://localhost:3306/walmart_app_database";
        String databaseUserName = "root";
        String databasePassword = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl,databaseUserName,databasePassword);
            System.out.println("connected to database !!!");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /*
     * This method helps to close the connection with databse
     */
    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
