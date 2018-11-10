/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopatternwithjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Biju Ale
 */
public class ConnectionFactory {

    public static String URL = "jdbc:mysql://127.0.0.1:3306/homestead"; //Identify port
    public static String username = "root"; //Get permit/documents
    public static String password = ""; //Get permit/documents

    public static Connection conn;

    //1. Hire translator
    public ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //2. Build road
    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, username, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    //3. Close road
    public static void closeConnection() {
        if (conn != null) {
            try {
                //Check first if road is built
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
