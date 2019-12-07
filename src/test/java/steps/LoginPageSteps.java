package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.Cookie;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.AppConstants.*;
import static core.UiElements.FIRST_CONFIRM_POPUP_TEXT;
import static core.UiElements.SECOND_CONFIRM_POPUP_TEXT;
import static org.junit.Assert.fail;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("^login page is opened$")
    public void openTacLoginPage() {
        open(BASE_URL);
        loginPage.isLoaded();
    }

    @When("enter username {}")
    public void enterUsername(String username) {
        loginPage.getLoginInput().doubleClick().setValue(username);
    }

    @And("enter password {}")
    public void loginTacWithUserNameAndPwd(String password) {
        loginPage.getPasswordInput().doubleClick().setValue(password);
    }

    @And("hover over 'Hover me faster!' button")
    public void hoverOverElement() {
        loginPage.getHoverMeFasterButton().hover();
    }

    @And("click 'Sign in' button")
    public void clickOnSignInButton() {
        loginPage.getSignInButton()
                .waitUntil(Condition.enabled, 15000)
                .click();
    }

    @And("click 'OK' in first alert popup")
    public void clickOkInFirstAlertPopup() {
        confirm(FIRST_CONFIRM_POPUP_TEXT);
    }

    @And("click 'OK' in second alert popup")
    public void clickOkInSecondAlertPopup() {
        confirm(SECOND_CONFIRM_POPUP_TEXT);
    }

    @Given("log in to application with authentication token")
    public void logInWithCookies() {
        Cookie authentication = new Cookie("secret", "IAmSuperSeleniumMaster");
        getWebDriver().manage().addCookie(authentication);
        refresh();
    }

    @And("wait for 'Sign in' button is visible")
    public void waitForSignInButton() {
        loginPage.getSignInButton()
                .waitUntil(Condition.enabled, 15000);
    }

    @When("clear {}")
    public void clearInput(String input) {
        switch (input) {
            case "username":
                loginPage.getLoginInput().doubleClick().setValue(Strings.EMPTY);
                break;
            case "password":
                loginPage.getPasswordInput().doubleClick().setValue(Strings.EMPTY);
                break;
            default:
                throw new RuntimeException("Wrong input field");
        }
    }

    @Then("check validation for {} text input")
    public void checkValidation(String input) {
        //TODO Implement this step after fixing the issue with validation for login with empty username/password
        clickOkInFirstAlertPopup();
        clickOkInSecondAlertPopup();
        fail("Validation is not implemented");
    }

    @Then("check login failed message")
    public void checkLoginFailed() {
        //TODO Implement this step after fixing the issue with validation for login with wrong username/password
        fail("Validation is not implemented");
    }

}
