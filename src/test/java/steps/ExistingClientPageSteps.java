package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import pages.ExistingClientPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.UiElements.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ExistingClientPageSteps {

    private ExistingClientPage existingClientPage = new ExistingClientPage();

    @Then("^existing client page is opened$")
    public void openTacLoginPage() {
        existingClientPage.isLoaded();
    }

    @Then("Article to read block has correct sections")
    public void checkBlockWithArticles() {
        existingClientPage.getSectionButton(ARTICLES_TO_READ, ADVERTISERS).shouldBe(visible);
        existingClientPage.getSectionButton(ARTICLES_TO_READ, PUBLISHERS).shouldBe(visible);
        existingClientPage.getSectionButton(ARTICLES_TO_READ, TOP_LEVEL_CLIENTS).shouldBe(visible);
    }

    @And("click on {} section in {} block")
    public void clickSectionInBlock(String section, String block) {
        existingClientPage.getSectionButton(block, section).click();
    }

    @And("{} section has {} articles in {} block")
    public void checkNumberOfArticlesInSection(String section, int number, String block) {
        existingClientPage.checkNumberOfArticlesInSection(block, section, number);
    }

    @And("click on {} article")
    public void selectArticle(String article) {
        existingClientPage.getArticleButton(article).click();
    }

    @Then("{} block has {} section")
    public void checkSectionInBlock(String block, String section) {
        existingClientPage.getSectionButton(block, section).shouldBe(visible);
    }

    @And("check that cookies {} has value {}")
    public void checkCookiesValue(String cookieName, String cookieValue) {
        Cookie cookie = getWebDriver().manage().getCookieNamed(cookieName);
        assertTrue(cookie.getValue().contains(cookieValue));
    }

    @When("open user profile page")
    public void openUserProfilePage() {
        existingClientPage.getAvatarImg().click();
    }

    @And("Saved articles block disappeared")
    public void checkBlockIsInvisible() {
        existingClientPage.getSavedArticlesPane().shouldNotBe(visible);
    }

    @And("check that cookies {} has been removed")
    public void checkCookiesRemoved(String cookieName) {
        Cookie cookie = getWebDriver().manage().getCookieNamed(cookieName);
        assertNull("Cookie hasn't been removed", cookie);
    }

}
