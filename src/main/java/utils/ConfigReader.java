package utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILE = "src\\main\\resources\\config.properties";
    private static Properties configProps;

    private ConfigReader() {
    }

    static {
        try {
            FileReader reader = new FileReader(CONFIG_FILE);
            configProps = new Properties();
            configProps.load(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configProps.getProperty(key);
    }

}
