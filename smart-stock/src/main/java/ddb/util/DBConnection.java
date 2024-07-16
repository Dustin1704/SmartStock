package ddb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //---------- PROPERTIES ----------//
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
                // Get connection using config properties
                connection = DriverManager.getConnection(
                    Config.getDbUrl(), 
                    Config.getDbUser(), 
                    Config.getDbPassword()
                );
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
