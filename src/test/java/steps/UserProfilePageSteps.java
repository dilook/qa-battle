package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.UserProfilePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.UiElements.*;
import static org.junit.Assert.assertEquals;

public class UserProfilePageSteps {

    private UserProfilePage userProfilePage = new UserProfilePage();

    private String firstName;
    private String lastName;
    private String cardNumber;
    private String paymentSystem;
    private String dayOfPayment;

    @And("enter {} in {} field")
    public void enterTextInField(String value, String inputField) {
        switch (inputField) {
            case FIRST_NAME:
                userProfilePage.getFirstNameInput().setValue(value);
                firstName = value;
                break;
            case LAST_NAME:
                userProfilePage.getLastNameInput().setValue(value);
                lastName = value;
                break;
            case CARD_NUMBER:
                userProfilePage.getCardNumberInput().setValue(value);
                cardNumber = value;
                break;
            default:
                throw new RuntimeException("Wrong field");
        }
    }

    @And("press {} button")
    public void pressButton(String button) {
        switch (button) {
            case SAVE_USER_INFO:
                userProfilePage.getSaveUserInfoButton().click();
                break;
            case SAVE_PAYMENT_INFO:
                userProfilePage.getSavePaymentInfoButton().click();
                break;
            default:
                throw new RuntimeException("Wrong button");
        }
    }

    @Then("check user info successfully saved message")
    public void checkUserInfoSuccessfullySavedMessage() {
        userProfilePage.getUserSuccessSaveAlert().shouldHave(text(USER_SUCCESSFULLY_SAVED_MESSAGE));
    }

    @And("check user info")
    public void checkUserInfo() {
        assertEquals(firstName, userProfilePage.getValueFromInput("firstNameInput"));
        assertEquals(firstName, getWebDriver().manage().getCookieNamed("firstName").getValue());
        assertEquals(lastName, userProfilePage.getValueFromInput("lastNameInput"));
        assertEquals(lastName, getWebDriver().manage().getCookieNamed("lastName").getValue());
    }

    @Then("check validation for {} input field")
    public void checkValidationForField(String input) {
        switch (input) {
            case FIRST_NAME:
                userProfilePage.getFirstNameInput().shouldHave(attribute(CLASS, FORM_CONTROL_IS_INVALID));
                userProfilePage.getSelectFirstNameMessage().shouldHave(text(SELECT_FIRSTNAME));
                break;
            case LAST_NAME:
                userProfilePage.getLastNameInput().shouldHave(attribute(CLASS, FORM_CONTROL_IS_INVALID));
                userProfilePage.getSelectLastNameMessage().shouldHave(text(SELECT_LASTNAME));
                break;
            case CARD_NUMBER:
                userProfilePage.getCardNumberInput().shouldHave(attribute(CLASS, FORM_CONTROL_IS_INVALID));
                userProfilePage.getSelectCardNumberMessage().shouldHave(text(SELECT_CARD_NUMBER));
                break;
            case PAYMENT_SYSTEM:
                userProfilePage.getPaymentSystemDropdown().shouldHave(attribute(CLASS, "custom-select is-invalid"));
                userProfilePage.getSelectPaymentSystemMessage().shouldHave(text(SELECT_PAYMENT_SYSTEM));
                break;
            default:
                throw new RuntimeException("Wrong field");
        }
    }

    @And("click on Payment Info")
    public void goToPaymentInfo() {
        userProfilePage.getPaymentInfoButton().click();
    }

    @And("select {} in payment system dropdown")
    public void selectValueInPaymentDropdown(String payment) {
        userProfilePage.getPaymentSystemDropdown().selectOptionContainingText(payment);
        paymentSystem = payment;
    }

    @And("set {} for day of payment")
    public void setDayOfPayment(int day) {
        for (int i = 1; i < day; i++) {
            userProfilePage.getPaymentRangeSlider().sendKeys(Keys.RIGHT);
        }
        dayOfPayment = String.valueOf(day);
    }

    @Then("check payment info successfully saved message")
    public void checkPaymentSuccessfullySavedMessage() {
        userProfilePage.getPaymentSuccessSaveAlert().shouldHave(text(PAYMENT_SUCCESSFULLY_SAVED_MESSAGE));
    }

    @And("check payment info")
    public void checkPaymentInfo() {
        assertEquals(cardNumber, userProfilePage.getValueFromInput("cardNumberInput"));
        assertEquals(cardNumber, getWebDriver().manage().getCookieNamed("cardNumber").getValue());
        assertEquals(paymentSystem, userProfilePage.getPaymentSystemDropdown().getSelectedText());
        assertEquals("Current value: " + dayOfPayment, userProfilePage.getPaymentDayCurrentValue().getText());
    }

    @And("check default payment day is displayed")
    public void checkDefaultPaymentDay() {
        assertEquals("Current value: " + 1, userProfilePage.getPaymentDayCurrentValue().getText());
    }

}
