package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ClientCardPage;

import static com.codeborne.selenide.Selenide.actions;
import static core.AppConstants.FILE_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.FileUtils.*;

public class ClientCardPageSteps {

    private ClientCardPage cardPage = new ClientCardPage();

    @And("{} card is opened")
    public void checkCardIsOpened(String article) {
        cardPage.cardPageIsLoaded(article);
    }

    @And("click on {} button")
    public void clickOnButton(String button) {
        switch (button) {
            case "Download info":
                cardPage.getDownloadInfoButton().click();
                break;
            case "Move to saved":
                cardPage.getMoveToSavedButton().click();
                break;
            case "Removed from saved":
                cardPage.getRemoveFromSavedButton().click();
                break;
            default:
                throw new RuntimeException("Button not found");
        }
    }

    @Then("description is downloaded")
    public void checkFileIsDownloaded() {
        assertTrue("File hasn't been downloaded", isFileDownloaded(FILE_NAME, 10));
    }

    @And("file contains correct text")
    public void checkFile() {
        String expectedText = cardPage.getTextArea().getText();
        String actualText = readFileFromDownloadFolder(FILE_NAME);
        assertEquals("Wrong text in downloaded file", expectedText, actualText);
        assertTrue("Cannot delete file", removeFileFromDownloadFolder(FILE_NAME));
    }

    @And("'Move to saved' button is {}")
    public void checkMoveToSavedButton(String state) {
        switch (state) {
            case "disabled":
                cardPage.getMoveToSavedButton().scrollTo().shouldBe(Condition.disabled);
                break;
            case "enabled":
                cardPage.getMoveToSavedButton().scrollTo().shouldBe(Condition.enabled);
                break;
            default:
                throw new RuntimeException("Wrong button state");
        }
    }

    @And("scroll down in text area")
    public void scrollDownInTextArea() {
        cardPage.scrollToHeight();
    }

    @And("check image is resized with slider")
    public void checkImageIsResized() {
        cardPage.getSlider().scrollTo();
        int imgWidth = cardPage.getImgWidth();
        int imgHeight = cardPage.getImgHeight();
        double scrollOffsetPercentage = cardPage.getSliderOffsetPercentage();
        double scrollOffsetPercentageMax = 100;
        int movementStep = 20;
        while (scrollOffsetPercentage < scrollOffsetPercentageMax) {
            actions().clickAndHold(cardPage.getSliderWebElement())
                    .moveByOffset(movementStep, 0)
                    .release()
                    .build()
                    .perform();
            int imgWidthCurrent = cardPage.getImgWidth();
            int imgHeightCurrent = cardPage.getImgHeight();
            assertTrue("Image hasn't been resized: scrollOffsetPercentage=" + scrollOffsetPercentage,
                    imgWidthCurrent > imgWidth);
            assertTrue("Image hasn't been resized: scrollOffsetPercentage" + scrollOffsetPercentage,
                    imgHeightCurrent > imgHeight);
            imgWidth = imgWidthCurrent;
            imgHeight = imgHeightCurrent;
            scrollOffsetPercentage = cardPage.getSliderOffsetPercentage();
        }
    }

}
