package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static core.UiElements.LOGIN_FORM_TEXT_HEADER;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Getter
public class LoginPage {

    private SelenideElement loginFormHeader = $(xpath("//h4"));
    private SelenideElement loginInput = $(id("loginInput"));
    private SelenideElement passwordInput = $(id("passwordInput"));
    private SelenideElement hoverMeFasterButton = $(xpath("//button[contains(text(), 'Hover me faster!')]"));
    private SelenideElement signInButton = $(xpath("//img[@src='sign.png']"));
    private SelenideElement loaderIcon = $(xpath("//div[@id='loader']"));

    public void isLoaded() {
        loginFormHeader.shouldHave(text(LOGIN_FORM_TEXT_HEADER));
    }

}
