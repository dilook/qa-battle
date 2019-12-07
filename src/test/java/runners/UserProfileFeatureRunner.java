package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import runners.common.BaseRunner;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = "classpath:steps",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        monochrome = true,
        tags = "@user")
@RunWith(Cucumber.class)
public class UserProfileFeatureRunner extends BaseRunner {
}
