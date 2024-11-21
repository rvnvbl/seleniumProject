package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    // Constructor to load the properties file
    public ConfigReader(String configFilePath) {
        loadConfig(configFilePath);
    }

    // Load configuration from the properties file
    private void loadConfig(String configFilePath) {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(configFilePath)) {
            // Load the properties file
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file: " + configFilePath, e);
        }
    }

    // Get a String property from the properties file
    public String getStringProperty(String key) {
        return properties.getProperty(key);
    }

    // Get an Integer property from the properties file
    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    // Get a Boolean property from the properties file (if needed)
    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
