package core;

import utils.ConfigReader;

public class AppConstants {

    private AppConstants() {
    }

    //WebDriver
    public static final String BASE_URL = ConfigReader.getProperty("webdriver.base.url");
    public static final String BROWSER = ConfigReader.getProperty("webdriver.driver");
    public static final int TIMEOUT = Integer.parseInt(ConfigReader.getProperty("webdriver.timeout"));

    //Common
    public static final String DOWNLOAD_PATH = ConfigReader.getProperty("download.path");
    public static final String FILE_NAME = "data.txt";

}
