package ddb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    

    //---------- PROPERTIES ----------//
    private static final Properties configProperties = new Properties();
    
    //---------- LOAD PROPERTIES ----------//
    /**
     * Loads in the config properties file
     */
    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            configProperties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //---------- GETTERS ----------//
    public static String getConfigProperty(String key) { return configProperties.getProperty(key); }

    public static String getDbUrl() { return configProperties.getProperty("db.url"); }
    public static String getDbUser() { return configProperties.getProperty("db.user"); }
    public static String getDbPassword() { return configProperties.getProperty("db.password"); }


}
