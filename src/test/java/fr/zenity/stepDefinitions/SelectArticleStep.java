package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.ArticlePage;
import fr.zenity.pageObjects.HomePage;
import io.cucumber.java8.En;

public class SelectArticleStep implements En {

    public SelectArticleStep(ArticlePage articlePage, HomePage homePage){
        Given("^user is on result page$", () -> {
            homePage.navigateTo();
            articlePage.searchArticle();
            articlePage.isSearchPage();
        });

        When("^user select the first article on the page$", () -> {
            articlePage.selectFirst();
        });

        Then("^he should be on the article page$", () -> {
            articlePage.isSelected();
        });
    }
}
