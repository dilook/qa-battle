package runners.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static core.AppConstants.BROWSER;
import static core.AppConstants.TIMEOUT;

public class BaseRunner {

    @BeforeClass
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.timeout = TIMEOUT;
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }

}
