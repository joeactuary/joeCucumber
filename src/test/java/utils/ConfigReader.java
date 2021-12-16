package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader extends CommonMethods2{

    static Properties properties;

    public static Properties readProperties(String filePath) {


        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static String getPropertyValue(String key) {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        return properties.getProperty(key);
    }

}

