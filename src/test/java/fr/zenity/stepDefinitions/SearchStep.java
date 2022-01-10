package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.HomePage;
import fr.zenity.pageObjects.ArticlePage;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;


public class SearchStep implements En {
    private WebDriver driver;

    public SearchStep(HomePage homePage, ArticlePage articlePage) {
        Given("^user is on home page$", () -> {
            homePage.navigateTo();
        });

        When("^user do a research on the article$", () -> {
            articlePage.searchArticle();
        });
        Then("^he should be on the result page matching with research$", () -> {
            articlePage.isSearchPage();
        });
    }
}
