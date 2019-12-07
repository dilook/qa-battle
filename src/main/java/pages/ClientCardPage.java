package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static core.UiElements.STYLE;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static utils.StringUtils.getStringByPattern;

@Getter
public class ClientCardPage extends BasePage {

    private SelenideElement loaderIcon = $(xpath("//div[@id='loader']"));
    private SelenideElement cardTitle = $(xpath("//h5[@class='card-title']"));
    private SelenideElement textArea = $(xpath("//textarea"));
    private SelenideElement downloadInfoButton = $(xpath("//button[text()='Download info']"));
    private SelenideElement moveToSavedButton = $(xpath("//button[text()='Move to saved']"));
    private SelenideElement removeFromSavedButton = $(xpath("//button[text()='Removed from saved']"));
    private SelenideElement heroImage = $(id("heroImage"));
    private SelenideElement slider = $(xpath("//span[contains(@class, 'ui-slider-handle')]"));

    public void cardPageIsLoaded(String card) {
        loaderIcon.shouldNotBe(visible);
        cardTitle.shouldHave(text(card));
    }

    public WebElement getSliderWebElement() {
        return getWebElementByXpath("//span[contains(@class, 'ui-slider-handle')]");
    }

    public double getSliderOffsetPercentage() {
        String sliderStyleAttribute = slider.getAttribute(STYLE);
        return Double.parseDouble(getStringByPattern(sliderStyleAttribute, "\\d+(\\.\\d+)?"));
    }

    public int getImgWidth() {
        String imgStyleAttributes = heroImage.getAttribute(STYLE);
        return Integer.parseInt(imgStyleAttributes.substring(7, 10));
    }

    public int getImgHeight() {
        String imgStyleAttributes = heroImage.getAttribute(STYLE);
        return Integer.parseInt(imgStyleAttributes.substring(22, 25));
    }

}
