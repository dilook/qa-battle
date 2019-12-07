package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Getter
public class ExistingClientPage {

    private SelenideElement loaderIcon = $(xpath("//div[@id='loader']"));
    private SelenideElement avatarImg = $(id("avatar"));
    private SelenideElement articlesToReadPane = $(xpath("//div[text()='Articles to read']"));
    private SelenideElement savedArticlesPane = $(xpath("//div[text()='Saved articles']"));

    private String sectionItem = "//div[text()='%s']/following-sibling::div//button[text()='%s']";
    private String allArticleInSection = "//div[text()='%s']/following-sibling::div//button[text()='%s']"
            + "/following-sibling::div/div";
    private String articleItem = "//button[text()='%s']";

    public void isLoaded() {
        loaderIcon.shouldNotBe(visible);
        avatarImg.shouldBe(visible);
        articlesToReadPane.shouldBe(visible);
    }

    public void checkNumberOfArticlesInSection(String block, String section, int numberOfArticles) {
        $$(xpath(String.format(allArticleInSection, block, section))).shouldHave(size(numberOfArticles));
    }

    public SelenideElement getSectionButton(String block, String section) {
        return $(xpath(String.format(sectionItem, block, section)));
    }

    public SelenideElement getArticleButton(String article) {
        return $(xpath(String.format(articleItem, article)));
    }

}
