package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author achyut
 */
public class ConnectionFactory {

    private static final String URI = "jdbc:mysql://127.0.0.1:3306/homestead";
    private static final String USER = "root";
    private static final String PWD = "";

    private static Connection conn;

    private ConnectionFactory() {
        try {
            // 1. Hire the transalator
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        // 2. Build a singleton road
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URI, USER, PWD);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
