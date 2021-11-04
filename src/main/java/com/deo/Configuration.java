package com.deo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {



    private static void getProperties() {
        try (InputStream input = Configuration.class.
                getClassLoader().
                getResourceAsStream("application.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");}
            //load a properties file from class path, inside static method
            prop.load(input);
            //bind props with reserved strings
            host = prop.getProperty("serverName");
            port = prop.getProperty("port");
            database = prop.getProperty("database");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
