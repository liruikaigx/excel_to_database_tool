package mysql.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDatabase {
    private static final String propertiesPath = "/Users/ruikai.lithoughtworks.com/Documents/project/toMySQL/resourses/application.properties";

    public static Connection getConnection() throws SQLException {
        String connectUrl = "";
        String connectUser = "";
        String connectPassword = "";

        try {
            Properties properties = new Properties();
            InputStream input = new BufferedInputStream(new FileInputStream(propertiesPath));
            properties.load(input);

            connectUrl = properties.getProperty("mysql.url");
            connectUser = properties.getProperty("mysql.user");
            connectPassword = properties.getProperty("mysql.password");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot found properties file.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(connectUrl, connectUser, connectPassword);
    }
}