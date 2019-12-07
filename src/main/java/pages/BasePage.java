package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {

    public void scrollToHeight() {
        ((JavascriptExecutor) getWebDriver())
                .executeScript("textarea = document.getElementsByTagName('textarea')[0];"
                        + "textarea.scrollTop=textarea.scrollHeight");
    }

    public String getValueFromInput(String elementId) {
        return (String) ((JavascriptExecutor) getWebDriver())
                .executeScript("return document.getElementById('" + elementId + "').value");
    }

    WebElement getWebElementByXpath(String xpath) {
        return getWebDriver().findElement(By.xpath(xpath));
    }

}
