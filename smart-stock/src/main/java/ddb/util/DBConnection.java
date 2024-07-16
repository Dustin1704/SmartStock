package ddb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //---------- PROPERTIES ----------//
    private static final String URL = "jdbc:mysql://localhost:3306/smartstock";
    private static final String USER = "root";
    private static final String PASSWORD = "passWord";
    private static Connection connection = null;

    //---------- CONSTRUCTOR ----------//
    /**
     * Private DBConnection Constructor.
     * Prevent Instatiation
     */
    private DBConnection(){}

    //---------- OPEN/CLOSE CONNECTION ----------//
    /**
     * Gets the connection to the MySQL Database
     * @return the open connection
     */
    public static Connection getConnection(){
        // If no connection is set, Try to open a new connection
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Cannot connect to the database!");
            }
        }
        return connection;
    }

    /**
     * Close the connection to the MySQL Database
     */
    public static void closeConnection(){
        // If a connection is set, close it
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Failed to close the database connection!");
            }
        }
    }
}
