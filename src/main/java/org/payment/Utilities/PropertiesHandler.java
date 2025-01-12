package org.payment.Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {

    private final Properties properties = new Properties();

    public PropertiesHandler() {
        try {
            InputStream input = new FileInputStream("src/test/java/Connector/GeneralFile.properties");
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

}
