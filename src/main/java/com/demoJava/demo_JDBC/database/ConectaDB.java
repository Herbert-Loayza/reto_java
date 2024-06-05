package com.demoJava.demo_JDBC.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConectaDB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties props = new Properties();
                InputStream inputStream = ConectaDB.class.getClassLoader().getResourceAsStream("application.properties");
                props.load(inputStream);

                String driver = props.getProperty("spring.datasource.driver-class-name");
                String url = props.getProperty("spring.datasource.url");
                String user = props.getProperty("spring.datasource.username");
                String password = props.getProperty("spring.datasource.password");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
