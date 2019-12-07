package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Getter
public class UserProfilePage extends BasePage {

    private SelenideElement pageHeader = $(xpath("//div[@class='card-header text-center']"));
    private SelenideElement userProfileButton = $(xpath("//a[text()='User Profile']"));
    private SelenideElement paymentInfoButton = $(xpath("//a[text()='Payment info']"));
    private SelenideElement firstNameInput = $(id("firstNameInput"));
    private SelenideElement lastNameInput = $(id("lastNameInput"));
    private SelenideElement saveUserInfoButton = $(xpath("//button[text()='Save user info']"));
    private SelenideElement cardNumberInput = $(id("cardNumberInput"));
    private SelenideElement paymentSystemDropdown = $(id("paymentSystemSelect"));
    private SelenideElement savePaymentInfoButton = $(xpath("//button[contains(text(), 'Save payment info')]"));
    private SelenideElement paymentRangeSlider = $(id("paymentRange"));
    private SelenideElement userSuccessSaveAlert = $(id("successUserInfoSaveInfo"));
    private SelenideElement paymentSuccessSaveAlert = $(id("successPaymentInfoSaveInfo"));
    private SelenideElement selectFirstNameMessage = $(xpath("//input[@id='firstNameInput']"
            + "/../div[@class='invalid-feedback']"));
    private SelenideElement selectLastNameMessage = $(xpath("//input[@id='lastNameInput']/"
            + "../div[@class='invalid-feedback']"));
    private SelenideElement selectCardNumberMessage = $(xpath("//input[@id='cardNumberInput']/"
            + "../div[@class='invalid-feedback']"));
    private SelenideElement selectPaymentSystemMessage = $(xpath("//select[@id='paymentSystemSelect']/"
            + "../div[@class='invalid-feedback']"));
    private SelenideElement paymentDayCurrentValue = $(xpath("//h6"));

}
